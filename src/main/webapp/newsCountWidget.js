function lineAttributes(cname,last30days,prev30days,since2015) {
		this.cname = cname;
		this.last30days = last30days;
		this.prev30days = prev30days;
		this.since2015 = since2015;
}
	
var countList = loadCountList();
var app = angular.module('viewerControllerApp', []);

app.controller('ViewController', function($scope) {
    $scope.countList= countList;
});

function loadCountList() {
  	//var datesUrl = "alarmlog/Index of __tad.html";
	/* 201802
  	var datesUrl = "/proxy8181?method=retrievenewscountrysum"
	*/
  	var datesUrl = "/agent8181?method=retrievenewscountrysum"
  	/*
    if (window.location.hostname == "127.0.0.1") {
  	  datesUrl = "http://127.0.0.1:8084/alarmlog/";
    }
  	*/
  	var xmlhttp;
  	if (window.XMLHttpRequest)
  	  {// code for IE7+, Firefox, Chrome, Opera, Safari
  	  xmlhttp=new XMLHttpRequest();
  	  }
  	else
  	  {// code for IE6, IE5
  	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  	  }
//  	
//  Asyncronize	
//  	xhr.timeout = 2000; // time in milliseconds
//  	xhr.onload = function () {
//  	  // Request finished. Do processing here.
//  	};
//  	xhr.ontimeout = function (e) {
//  	  // XMLHttpRequest timed out. Do something here.
//  	};
  	
  	xmlhttp.open("GET",datesUrl,false);
  	xmlhttp.send();
  	var result=xmlhttp.responseText;
  	

	var tmp = result.split("@");
	var tmpLast30days = tmp[0].split(";");
	var cname = new Array();
	var last30days = new Array();
	var tmp2 = Array();
	for (var i = 0; i < tmpLast30days.length; i++) {
		tmp2 = tmpLast30days[i].split(",");
		cname[i] = tmp2[0];
		last30days[i] = tmp2[1];
	}

	var prev30days = new Array();
	var since2015 = new Array();	
	prev30days = tmp[1].split(";");
	since2015 = tmp[2].split(";");
  	
	var list = new Array();
	for (var i = 0; i < tmpLast30days.length; i++) {
		list[i] = new lineAttributes(cname[i],last30days[i],prev30days[i], since2015[i]);
	}
	/*
	for (var nn in list) { // NG not object
		console.log(nn.cname + nn.last30days + nn.prev30day + nn.since2015);
	}
	for (var i = 0; i < tmpLast30days.length; i++) {
		console.log(i + list[i].cname + list[i].last30days + list[i].prev30day + list[i].since2015);
	}
	*/
  	return list;
}
  
