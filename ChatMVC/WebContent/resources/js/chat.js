var stompClient = null;
var stompClientDraw = null;
var url = "/wsApp/chat/";
var urlDraw = "/wsApp/draw";

function connect() {
    var socket = new SockJS('/ChatMVC/chat');
	stompClient = Stomp.over(socket);
	
	console.log("test");
	
    stompClient.connect({}, function(frame) {
        console.log('Connected for Chat: ' + frame);
        console.log("Chat ID: " +$("#chatId").val());
        
//        stompClient.subscribe("/topic/showMessage/"+ $("#chatId").val(), console.debug);
        
//        stompClient.subscribe("/topic/showMessage/"+ $("#chatId").val() , function(chatResult){
        	stompClient.subscribe("/topic/showMessage/"+ $("#chatId").val() , function(chatResult){
        	
        	console.log("received!!!");
        	//console.log(chatResult.body);
        	
        	//showResult(chatResult.body);
        	showResult(JSON.parse(chatResult.body));
//        	showResult(chatResult.body);
        });
     
        	
    });
}








function connectDraw() {
    var socket = new SockJS('/ChatMVC/draw');
	stompClientDraw = Stomp.over(socket);
	
	console.log("draw socket");
	
    stompClientDraw.connect({}, function(frame) {
        console.log('Connected for Draw: ' + frame);
        console.log("Draw(Chat) ID: " +$("#chatId").val());
        
        stompClientDraw.subscribe("/topic/showDraw/"+ $("#chatId").val() , function(chatResult){
        	
        	
        	console.log("received Draw!!!");
        	
        	var test =JSON.parse(chatResult.body);
        	
        	//console.log(test);
        	
        	canvas.loadFromJSON(test, canvas.renderAll.bind(canvas), function(o, object) {});
        	//canvas.loadFromJSON(test);
        	
        	
        	//canvas.add(test)
        	
        });
     
        	
    });
}









function send() {
    stompClient.send(url, {}, JSON.stringify({ 'usr': $("#userId").val() ,'message': $("#message").val() }));
}

function showResult(msg) {
	
	
	console.log("in show result")
	//var test = JSON.parse(msg);
	console.log(msg);
	
	//if (msg.sender.profilePic == true)
	//	$("#chatDiv").append("<p><img src='resources/imgs/" + msg.sender.username + ".png' width='32' /><strong>" + msg.sender.firstname + " " + msg.sender.lastname + "</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg.dateTime.dayOfMonth + "/" + msg.dateTime.monthValue + "/" + msg.dateTime.year + " " + msg.dateTime.hour + ":" + msg.dateTime.minute + "</p><pre>" + msg.message + "</pre><hr/>");
	//else
	//	$("#chatDiv").append("<p><img src='resources/imgs/nopic.png' width='32' /><strong>" + msg.sender.firstname + " " + msg.sender.lastname + "</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg.dateTime.dayOfMonth + "/" + msg.dateTime.monthValue + "/" + msg.dateTime.year + " " + msg.dateTime.hour + ":" + msg.dateTime.minute + "</p><pre>" + msg.message + "</pre><hr/>");
		$("#chatDiv").append("<pre>" + msg.author.username +" : "+msg.content + "</pre><hr/>");
}

$(document).ready(function(){
	url = "/wsApp/chat/" + $("#chatId").val();
	
	urlDraw = "/wsApp/draw/" + $("#chatId").val();
	
	
	connect();
	
	$("#sendBtn").click(function(){
		send();
	});
	
	
	
	
	
	
	canvas = new fabric.Canvas('c', {
	    selection: false
	});
	
	canvas.freeDrawingBrush = new fabric['PencilBrush'](canvas);
	
	//sets default draw mode
	drawMode = "free";
	canvas.isDrawingMode = true;
	
	//connect to websocket
	connectDraw();
	
	
	
	
	
	
	
	canvas.on('mouse:down', function(o) {
		
		mouseLeftState = true;
		
		isDown = true;
		var pointer = canvas.getPointer(o.e);
		origX = pointer.x;
		origY = pointer.y;

		if (drawMode == "free") {
			canvas.isDrawingMode = true;
			
		}
		
		

	});
	
	
	canvas.on('mouse:up', function(o) {
		
		var size = canvas.size();
		console.log(size);
		
		var lastObject = canvas.item(size-1);
		console.log(JSON.stringify(lastObject));
		
		// stompClientDraw.send(urlDraw, {}, JSON.stringify(lastObject));
		
		 stompClientDraw.send(urlDraw, {}, JSON.stringify(canvas));
		
	});
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});