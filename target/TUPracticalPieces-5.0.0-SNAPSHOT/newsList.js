    var locsArray;
    var gMap;
    var gMarker;
    function initializeGMap() {
    //function initMap() {
        var mapOptions = {
          center: new google.maps.LatLng(-34.397, 150.644),
          mapTypeId:google.maps.MapTypeId.ROADMAP,
          zoom: 8
        };
        gMap = new google.maps.Map(document.getElementById("mapcanvas"),
            mapOptions);
		//gMap = map;
	    gMarker = new google.maps.Circle({
	    	  center: {lat: -34.397, lng: 150.644},
	    	  radius:20000,
	    	  strokeColor:"#FF0000",
	    	  strokeOpacity:0.2,
	    	  strokeWeight:8,
	    	  fillColor:"#FF0000",
	    	  fillOpacity:0.4
	    	  });
	    gMarker.setMap(gMap);
    }
    /*
    function initMap() {
    // (the 'map' here is the result of the created 'var map = ...' above)
	    google.maps.event.trigger(map, "resize");
    });
    //google.maps.event.addDomListener(window, 'load', initializeGMap);
        
    */
    function setSpot(lat, lng) {
        var latlng = new google.maps.LatLng(parseFloat(lat), parseFloat(lng));
    	gMap.setCenter(latlng, 8);
    	gMarker.setCenter(latlng);
    	//document.getElementById("mapcanvas").trigger("resize");
    	//google.maps.event.trigger(gMap, 'resize');
    }
    
	function setListBox(JsonStr) {
		if (JsonStr == null || JsonStr.length <= 100) {
			var msgtempstr
			if (JsonStr == null || JsonStr.length == 0) {
				magtempstr = "null";
			} else {
				msgtempstr = JsonStr.substr(0, 100);
			}
			document.getElementById("waitMsg").innerHTML = document.getElementById("waitMsg").innerHTML +  "(Json ret):" + msgtempstr + ". Retrying...";
			return;
		}
//		initializeGMap();
        //20170430 replace &apos;
		JsonStr.replace(/'/g, "&apos;");
//		document.getElementById("msgBox").innerHTML = document.getElementById("msgBox").innerHTML +  JsonStr;
//		document.getElementById("waitMsg").innerHTML = document.getElementById("waitMsg").innerHTML +  JsonStr;
		
		locsArray = JSON.parse(JsonStr);
		if (locsArray.length < 5) { // normally 7
			displayError("cannot load news list from server.")
			return;
		}
		/*
		 * [["name": "Akashi", "lat":"35.000", "lng":"135.000", "news": "Jiken1","link": "http:www.example.com"],["name": "London", "lat":"35.000", "lng":"135.000", "news": "Jiken2","link": "http:www.example.com"]]
		 * 
		 */
		for (var i = 0; i < locsArray.length; i++) {
			var opt = document.createElement("OPTION");
			var tmp="....:....+....:....+....:....+....:....+....:....+....:....+....:....+....|";
			
			var tmpNews = locsArray[i][3]["news"];
			var tmpStr = "" + (i+1) + ". ";
			var ss = locsArray[i][0]["name"];
			/*
			tmpStr += ss.substring(0,(ss.length > 20) ? 20 : ss.length);
			tmpStr += "..............".substring(0,(ss.length > 20) ? 0 : 20 - ss.length);
			tmpStr += "|"; 
			var lenDiff = tmp.length-tmpNews.length;
			if (lenDiff > 0) {
				tmpStr += tmpNews + tmp.substring(tmpNews.length, lenDiff); 				
			} else {
				tmpStr += tmpNews.substring(0, 75); 								
			}
			*/
			tmpStr += ss + "  ---  " + tmpNews;
			
			opt.setAttribute("value", i);
			var t = document.createTextNode(tmpStr);
			opt.appendChild(t);
			
			/*
			opt.text=tmpStr;
			opt.value = i;
			opt.id = i;
			*/
			if (i==0) {
				opt.selected=true;
			}
			
		    document.getElementById("listLocs").appendChild(opt);
			/*
			function myFunction() {
			    var x = document.createElement("OPTION");
			    x.setAttribute("value", "volvocar");
			    var t = document.createTextNode("Volvo");
			    x.appendChild(t);
			    document.getElementById("mySelect").appendChild(x);
			}
			*/
			//document.getElementById("listLocs").options.add(opt);
		}
		/*
		 * object.onchange=function(){SomeJavaScriptCode};
		 */
	    document.getElementById("listLocs").onchange=onValueChange;
	    document.getElementById("linkNewsSource").href=locsArray[0][4]["link"];
	    document.getElementById("linkNewsSource").innerHTML=locsArray[0][3]["news"];
	    //document.getElementById("textStatus").innerHTML=locsArray[0][0]["name"];
	    document.getElementById("textStatus").value=locsArray[0][0]["name"];


	    /*
		var url = "";
	    if (window.location.host == "localhost:8888" ||
	    	window.location.host == "127.0.0.1:8888") {
	    	url="http://localhost:8888/map?lat=" +
	    		locsArray[0][1]["lat"] + "&lng=" + locsArray[0][2]["lng"];
	    } else {
	  	    url = "http://tupracticalpieces.appspot.com/map?lat=" +
	  	    	locsArray[0][1]["lat"] + "&lng=" + locsArray[0][2]["lng"];
	    }
		document.getElementById("mapPane").src=url;
		*/
	    
		initializeGMap();
		/*
	    setSpot(locsArray[0][1]["lat"], locsArray[0][2]["lng"]);
		google.maps.event.addListenerOnce(gMap, 'idle', function() {
    		google.maps.event.trigger(gMap, 'resize');
		});
		*/

/*		lastendDate = jsonData["supplyDetail"][0]["supplyDate"];
		lastStartDate = jsonData["supplyDetail"][(dataNum - 1)]["supplyDate"];
		for ( var i = 0; i < dataNum; i++) {
			totalGasMax += parseFloat(jsonData["supplyDetail"][i]["quantity"]);
			totalPriceMax += parseInt(jsonData["supplyDetail"][i]["totalPrice"]);
		}
		totalMileageMax = jsonData["supplyDetail"][0]["totalMileage"];
*/	}
	
	function setupMap() {
	    setSpot(locsArray[0][1]["lat"], locsArray[0][2]["lng"]);
		google.maps.event.addListenerOnce(gMap, 'idle', function() {
    		google.maps.event.trigger(gMap, 'resize');
		});	}
	
	function isNewsListEmpty() {
		if (document.getElementById("listLocs").length == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	function onValueChange() {
		var selectedNum = document.getElementById("listLocs").selectedIndex;
		var url;
		document.getElementById("msgBox").innerHTML="";
		document.getElementById("linkNewsSource").href=locsArray[selectedNum][4]["link"];
	    document.getElementById("linkNewsSource").innerHTML=locsArray[selectedNum][3]["news"];
		document.getElementById("textStatus").value=locsArray[selectedNum][0]["name"];
	    /*
	    if (window.location.host == "localhost:8888" ||
		    	window.location.host == "127.0.0.1:8888") {
	    	url="http://localhost:8888/map?lat=" +
	    		locsArray[selectedNum][1]["lat"] + "&lng=" + locsArray[selectedNum][2]["lng"];
	    } else {
	  	    url = "http://tupracticalpieces.appspot.com/map?lat=" +
	  	    	locsArray[selectedNum][1]["lat"] + "&lng=" + locsArray[selectedNum][2]["lng"];
	    }
		document.getElementById("mapPane").src=url;
		*/
	    setSpot(locsArray[selectedNum][1]["lat"], locsArray[selectedNum][2]["lng"]);
	}
	
	function displayError(s) {
		document.getElementById("msgBox").innerHTML=s;
	}

	function getLocName() {
		var selectedNum = document.getElementById("listLocs").selectedIndex;
	    return locsArray[selectedNum][0]["name"];
	}
