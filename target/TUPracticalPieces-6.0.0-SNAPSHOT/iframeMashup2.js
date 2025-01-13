function setIframe0OnClick() {
	document.getElementById("iframe1").contentWindow.document.body.onclick = function() {
    	window.open("https://ec2-52-193-61-161.ap-northeast-1.compute.amazonaws.com:9443/", "AccessControl");
	};
}
function setIframe1OnClick() {
	document.getElementById('iframe1').onload = function() {
		document.getElementById("iframe1").addEventListener('click', 
		function(event) {
    		window.open("https://127.0.0.1:3000/", "ServerInfo");
		},true);
	};
}