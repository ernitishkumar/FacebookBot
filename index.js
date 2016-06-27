'use strict'
var bodyParser = require('body-parser');

var express = require('express');

var requestModule = require("request");

var app = express();

// parse application/x-www-form-urlencoded 
app.use(bodyParser.urlencoded({ extended: false }));

// parse application/json 
app.use(bodyParser.json());

app.set('port', (process.env.PORT || 5000));

app.use(express.static(__dirname + '/public'));

// views is directory for all template files
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/', function(request, response) {
	response.render('pages/index');
});

app.listen(app.get('port'), function() {
	console.log('Node app is running on port', app.get('port'));
});


app.get('/webhook',function(request,response){
	var recievedToken = request.query['hub.verify_token'];
	console.log(request.query);
	if(recievedToken === '010991'){
		console.log("Request verified sending response");
		response.send(request.query['hub.challenge']);
	}else{
		console.log("Request failed");
	}
});

// handler receiving messages
app.post('/webhook', function (req, res) {
	var events = req.body.entry[0].messaging;
	for (var i = 0; i < events.length; i++) {
		var event = events[i];
		if(event.message && event.message.text){
			getMeaning(event.sender.id,event.message.text);	
		}
	}
	res.sendStatus(200);
});

// generic function sending messages
function sendMessage(recipientId, message) {
	requestModule({
		url: 'https://graph.facebook.com/v2.6/me/messages',
		qs: {access_token: process.env.PAGE_ACCESS_TOKEN},
		method: 'POST',
		json: {
			recipient: {id: recipientId},
			message: message,
		}
	}, function(error, response, body) {
		if (error) {
			console.log('Error sending message: ', error);
		} else if (response.body.error) {
			console.log('Error: ', response.body.error);
		}
	});
};

// Api site to get the meaning of the word
const END_SITE = 'https://glosbe.com/gapi/translate?from=eng&dest=eng&format=json&phrase=';

//Creating RegEx object for word matching
var regEx = new RegExp("^[a-zA-Z]+$");

function getMeaning(recipientId, word){
	word = word.trim();
	if(regEx.test(word)){
		console.log("Getting meaning for word : "+word+" senderId : "+recipientId);
		requestModule(
		{
			url: END_SITE+word,
			method: 'GET',
		}, function(error, response, body) {
			var status = response.status;
			console.log(status);
				if(status === 200){
				var result = body.tuc[0].meanings;
				console.log("Sending meanin as : "+JSON.stringify(result));
				sendMessage(recipientId, {text:JSON.stringify(result)});
				}else if (error) {
				console.log('Error getting meaning: ', error);
				} else if (response.body.error) {
				console.log('Error : ', response.body.error);
				}
			}
		);
	}else{
		var errorMessage = { 
			text : "Unable to get the meaning for "+word+", Please try Again with a new word!"
		};
		sendMessage(recipientId,errorMessage);
	}
}