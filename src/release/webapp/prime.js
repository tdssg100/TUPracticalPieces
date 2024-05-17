var graDepth = 60;
var graHeight = 1024;
var graWidth = 1024;
var gradIdx;
var freq;
var max;
var maxMod;
var multiRate;
var number;
var prime;
var totalCount = 0;
var prevMod = 8;
var tmp;
var tmpValue;
var results;
// screening prime number less than max	
function execValidation() {
	var min = 2;
	results = "";
//	results = "<a>" + nowTime.format("hh:mm:ss") + "</a>"
	if (document.getElementById("parameterTextBoxID").length == 0) {
		alert("Please input less than 1,000,000.");
		return false;
	}
	try {
		if (parseInt(document.getElementById("parameterTextBoxID").value) >= 1000000) {
			alert("Please input less than 1,000,000.");
			return false;
		}
	} catch (e) {
		alert("Please input less than 1,000,000.");
		return false;
	}
	if (parseInt(document.getElementById("parameterTextBoxID").value) < min) {
		alert("Please input less than 1,000,000.");
		return false;
	}
	if (parseInt(document.getElementById("rangeMaxModulo").value) < 2 ||
		parseInt(document.getElementById("rangeMaxModulo").value) > 1024) {
		alert("Please input integer between 2 and 1024.");
		return false;
	}
	max = parseInt(document.getElementById("parameterTextBoxID").value);
	//maxMod = (max > 1024) ? 1024 : max;
	maxMod = parseInt(document.getElementById("rangeMaxModulo").value);
    switch (true) {
      case (maxMod > 512): 
    	  	multiRate = 1;
  	  		break;
      case (maxMod > 256): 
    	  	multiRate = 2;
  	  		break;
      case (maxMod > 128): 
    	  	multiRate = 4;
  	  		break;
      case (maxMod > 64):
    	  	multiRate = 6;
      	  	break;
      default :
    	  	multiRate = 8;
    }
	//init graph header
	setGraphHeaderSub(maxMod);
	setGraphScale(maxMod);
	clearHistGraph();
	gradIdx = 1;
	return true;
}

function isDrawing() {
    if (gradIdx < max) {
	  return true;
    }
    return false;
}

function drawHistgramGradient() {
	gradIdx++;
	calcHist(gradIdx);
	drawHist();
    if (gradIdx == max) {
    	document.getElementById("statNum").innerHTML=totalCount;
    	document.getElementById("statModulo").innerHTML="click graph";
    	document.getElementById("statRemainder").innerHTML="click graph";
    	document.getElementById('primeNumFooter').innerHTML = results;
    }
}

function drawHistgramIncident() {
	calcHist(max);
	drawHist();
   	document.getElementById("statNum").innerHTML=totalCount;
   	document.getElementById("statModulo").innerHTML="click graph";
   	document.getElementById("statRemainder").innerHTML="click graph";
   	document.getElementById('primeNumFooter').innerHTML = results;
}

function calculatePrimeNumbers() {
	number = new Array();
	prime = new Array();
	for (var i = 0; i <= max; i++) {
		number[i] = true;
	}
	number[0] = false; // 0 is not a prime number.
	number[1] = false; // 1 is not a prime number.
	var divisor = 2;
    //	number.push(true); // inx=0
	//	number.push(true); // inx=1
	//number.push(true); // inx=2
	//prime[0] = 2;
	for (var i = 2; i <= Math.floor(max / 2); i++) {
		number[i * 2] = false;
	}
	divisor++; // from 3 with omitting multiples of 2
	while (divisor * divisor <= max) {
	    var multiFlag = false;
	    for (var k = 0; k < prime.length; k++) {
	    	if (divisor % prime[k] == 0) {
	    		multiFlag = true;
	    		break;
	    	}
	    }
	    if (!multiFlag) {
	      prime.push(divisor);
  		  for (var j = 2; j <= Math.floor(max / divisor); j++) {
			number[j * divisor]  = false;
		  }
	    }
	    divisor += 2;
    }
	/*
	for (var i = 0; i < max; i++ ) {
		if (number[i]) {
			results += "<a>" + i + "</a><a>,</a>"
		}
	}
	*/
//	if (document.getElementById("radioIsGradient").value != true) {
//		calcHist(max);
//		drawHist();
//	    document.getElementById("statNum").innerHTML=totalCount;
//	  	document.getElementById("statModulo").innerHTML="click graph";
//	  	document.getElementById("statRemainder").innerHTML="click graph";
//		document.getElementById('primeNumFooter').innerHTML = results;
//	}
//	var endTime = new Date();
	//results += "<a>total=" + (endTime - startTime) () + "former=" + (midTime - startTime) () + "later=" + (endTime - midTime) () + "</a>"
    //    printPrimeNumber(max);
}

function calcHist(max) {
    totalCount = 0;
    for (n = 0; n <= max; n++) {
    	if (number[n]){
    		totalCount++;
    	}
    }
    freq = new Array();
    freq.push(0); //idx 0
    freq.push(0); //idx 1
    for (var m = 2; m <= maxMod; m++) { // for modulo
        freq.push(new Array());
        var n = 0;
        for (n = 0; n < m; n++) { //prepare for remainders
        	freq[m].push(0);
        }
    	for (n = 0; n <= max; n++) {
    		if (number[n]) {
    			freq[m][n % m]++; 
    		}
    	}
    }
}
    	
function drawHist() {
	var context = document.getElementById("histgram").getContext('2d');
    for (var m = 2; m <= maxMod; m++) { // for modulo
		//results += "<a>total=" + parseInt(totalCount) () + "</a><br/>";
    	for (var p = 0; p < m; p++) {
    		//results += "<a>" + freq[p] + "</a><br/>";
    		if (freq[m][p] == 0) {
         		context.fillStyle = 'rgba(0,0,0,0.8)';
         		//context.strokeStyle = 'black';
    		} else {
    			if (totalCount < freq[m][p] * 2) {  // more than 50%
    				tmpValue = 0;
    			} else {
    				tmpValue = (1 - 2 * freq[m][p] / totalCount);
    			}
    			tmp = 255  * tmpValue;
//    			results += "<a>" + parseInt(tmpValue) () + 'rgba(255,' + parseInt(tmp) () + ',' + parseInt(tmp) () + ',0.8)' + "</a><br/>";
    			context.fillStyle = 'rgba(255,' + parseInt(tmp) + ',' + parseInt(tmp) + ',0.8)';
    		}
    		//context.fillRect(p,m,1,1);
    		context.fillRect(multiRate * p, multiRate * m, multiRate, multiRate);
    	}
    }
    /*
    for (n = 0; n < max; n++) {
    	if (number[n]){
    		results += "<a>" + n + ",</a>"
    	}
    }
    */
}

function showExplanation(cLeft, cTop) {
	var x = Math.floor(cLeft / multiRate);
	var y = Math.floor(cTop / multiRate);
	if (x >= y || x >= maxMod || y > maxMod) {
		return;
	}
  	document.getElementById("statNum").innerHTML = freq[y][x] + "/" + totalCount;
  	document.getElementById("statModulo").innerHTML = y;
  	document.getElementById("statRemainder").innerHTML = x;
}

function clearHistGraph() {
	var context = document.getElementById("histgram").getContext('2d');
	context.fillStyle = 'rgba(200,255,255,1.0)';
	context.fillRect(0,0,graWidth,graHeight);
}

function setGraphHeader() {
    var context = document.getElementById("primeNumHeader").getContext('2d');
    context.font = '12px Arial';
    context.fillText('Frequency(%) : rate of prime numbers by modulo to whole prime numbers', graDepth * 2, 20);
  	for (var p = 0; p < 128; p++) {
   		if (p == 0) {
		  context.fillStyle = 'rgba(0,0,0,0.8)';
		} else {
		  context.fillStyle = 'rgba(255,' + (255 - p) + ',' + (255 - p) + ',0.8)';
		}
   		//context.fillStyle = '#22FFFF';
  		context.fillRect(graDepth * 2 + p, 25, 1, 10);
  	}
  	context.fillStyle = 'rgba(0,0,0,1.0)';
  	context.fillText('0',graDepth * 2 - 4, 50);
  	context.fillText('50%',graDepth * 2 - 4 + 128, 50);
    return;
  }
  
function setGraphHeaderSub(max) {
    var context = document.getElementById("primeNumHeader").getContext('2d');

    context.fillStyle = 'rgba(255,255,255,1.0)';
	context.fillRect(graDepth,graDepth,graWidth,graDepth);

  	context.fillStyle = 'rgba(0,0,0,1.0)';
  	context.fillText('  remainder',graDepth * 2 - 4, 85);
	
  	context.fillRect(0, graDepth * 2 -3, 1, 2);

    context.fillText('0', graDepth, graDepth * 2 - 3);
    for (var i = Math.pow(2, Math.floor(10 - multiRate)); i < maxMod; i *= 2) {
  	    context.fillStyle = 'rgba(0,0,0,1.0)';
  		context.fillText(i, graDepth + i * multiRate, graDepth * 2 - 3);
  	}
    return;
  }

function setGraphScale(max) {
    var context = document.getElementById("primeNumScale").getContext('2d');

    context.fillStyle = 'rgba(255,255,255,1.0)';
	context.fillRect(0,0,graDepth,graHeight);
	
    context.save();
    context.translate(20, 40);
    context.rotate(Math.PI / 2);
    context.font = '12px Arial';
  	context.fillStyle = 'rgba(0,0,0,1.0)';
    context.fillText('modulo', 12, 20);
    context.restore();

    context.save();
    context.translate(graDepth - 12, 6);
    context.rotate(Math.PI / 2);
    context.font = '12px Arial';
  	context.fillStyle = 'rgba(0,0,0,1.0)';
	//context.fillRect(graDepth - 2,1,2,1);
	context.fillText(2, 12, 12);
    context.restore();
    
    for (var i = Math.pow(2, Math.floor(10 - multiRate)); i <= maxMod; i *= 2) {
  	  context.fillStyle = 'rgba(0,0,0,1.0)';
  	  //context.fillRect(graDepth - 3,i,2,1);
  	    
      context.save();
      context.translate(graDepth - 12, i * multiRate - 10);
      context.rotate(Math.PI / 2);
      context.font = '12px Arial';
      context.fillStyle = 'rgba(0,0,0,1.0)';
  	  context.fillText(i, 12, 12);
      context.restore();
  	}
    return;
  }

function printPrimeNumber(max) {
	var results = "";
//	for (var i = 0; i < max; i++ ) {
//		if (number[i]) {
//			results += "<a>" + i + "</a><a>,</a>"
//		}
//	}
	document.getElementById('primeNumFooter').innerHTML = results;
}	
  
  function changeMaxModulo() {
      var el = document.getElementById('rangeMaxModulo').value;
	  window.alert("about to set")
      document.getElementById('rangeMaxModuleValue').value = el;
  }
  
  function changeMaxModuloValue() {
      var el;
      try {
        el = parseInt(document.getElementById('rangeMaxModuloValue').value);
      } catch(e) {
    	  window.alert("Please input integer between 2 and 1024")
          document.getElementById('rangeMaxModuloValue').value = prevMod;
          return;
      }
      if (el < 2 || el > 1024) {
    	  window.alert("Please input integer between 2 and 1024")
          document.getElementById('rangeMaxModuloValue').value = prevMod;
          return;
      }
      prevMod = el;
	  window.alert("about to set")
      document.getElementById('rangeMaxModule').value = el;
  }
