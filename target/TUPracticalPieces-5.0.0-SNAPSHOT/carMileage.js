	var jsonData;
	var stl;
	var stlCom;
	var isBlur;
	var lastStartDate;
	var lastEndDate;
	var dataNum = 0;
	var startDate = Date();
	var endDate = Date();
	var totalPriceMax = 0;
	var totalPrice = 0;
	var totalMileageMax = 0;
	var totalMileage = 0;
	var totalGasMax = 0.0;
	var totalGas = 0.0;
	var hue = 0;

	
	function style(data,type,kind,src,max,min) {
		this.data = data;
		this.type = type;
		this.kind = kind;
		this.src = src;
		this.max = max;
		this.min = min;
		this.unit = "";
		this.color = "";
	}
	
	function styleCommon(startDate, endDate) {
		this.startDate = Date.parse(startDate);
		this.endDate = Date.parse(endDate);
		this.staInx = 0;
		this.endInx = 0;
	}
	
	function setStyleDomain(side) {
		var sumValue = 0.0;
		var tmpValue = 0.0;
		var maxValue = 0;
		var minValue = 0;
		var tmpDate = 0;
		var bas = 250;
		var amb1 = 0;
		var amb2 = 0;
		var isIn = new Boolean(true);
		
		amb1 = 80 * parseInt(stl[side].type);
		amb2 = 80 * parseInt(stl[side].kind);
		if (stl[side].data == 0) {
			stl[side].unit = "km";
			stl[side].color = 'rgba(' + bas + ',' + amb1 + ',' + amb2 + ',0.9)';
		} else if (stl[side].data == 1) {
			stl[side].unit = "L";
			stl[side].color = 'rgba(' + amb1 + ',' + bas + ',' + amb2 + ',0.9)';
		} else {
			stl[side].unit = "yen";
			stl[side].color = 'rgba(' + amb1 + ',' + amb2 + ',' + bas + ',0.9)';
		}
		for (i=dataNum -1; i >= 0; i--) {
			tmpDate = Date.parse(jsonData["supplyDetail"][i]["supplyDate"]);
			tmpValue = parseFloat(jsonData["supplyDetail"][i][stl[side].src]);
			sumValue += tmpValue;
			if ((tmpDate >= stlCom.startDate) && (tmpDate <= stlCom.endDate)) {
				isIn = true;
				if (side == 0) {
					if (tmpDate == stlCom.startDate) {
						stlCom.staInx = i;
					}
					if (tmpDate == stlCom.endDate) {
						stlCom.endInx = i;
					}
				}
			} else {
					isIn = false;
			}
			
			if (stl[side].type == 0) {
				if (i == 0) {
					maxValue = sumValue;
				}
			} else {
					if (tmpValue > maxValue) {
						maxValue = tmpValue;
					}
			}
		}
		stl[side].min = 0;
		stl[side].max = maxValue;
	}

	function setMileageData(JsonStr) {
		stlCom = new styleCommon (
				document.getElementById("graphOptionStartDate").value,
				document.getElementById("graphOptionEndDate").value
				);
		stl = new Array();
		stl[0] = new style(
			document.getElementById("graph1Option").value,
			document.getElementById("graph1OptionType").value,
			document.getElementById("graph1OptionKind").value,
			((document.getElementById("graph1Option").value== "0") ? "bsMileage" :
				((document.getElementById("graph1Option").value== "1") ?	"quantity":"totalPrice")),
			0,
			9999999.9
				);
		stl[1] = new style(
			document.getElementById("graph2Option").value,
			document.getElementById("graph2OptionType").value,
			document.getElementById("graph2OptionKind").value,
			((document.getElementById("graph2Option").value== "0") ? "bsMileage" :
					((document.getElementById("graph2Option").value== "1") ? "quantity":"totalPrice")),
			0,
			9999999.9
			);
		
		jsonData = eval("(" + JsonStr + ")");
		dataNum = jsonData["supplyDetail"].length

		lastendDate = jsonData["supplyDetail"][0]["supplyDate"];
		lastStartDate = jsonData["supplyDetail"][(dataNum - 1)]["supplyDate"];
		for ( var i = 0; i < dataNum; i++) {
			totalGasMax += parseFloat(jsonData["supplyDetail"][i]["quantity"]);
			totalPriceMax += parseInt(jsonData["supplyDetail"][i]["totalPrice"]);
		}
		totalMileageMax = jsonData["supplyDetail"][0]["totalMileage"];
	}
	
	function setgraph1Option(s) {
		var ss = s.split(",");
		for (var i =0; i < ss.length; i++) {
			document.getElementById("graph1Option").options[i] = new Option(ss[i], i);
  		}
	}
	function setgraph1OptionType(s) {
		var ss = s.split(",");
		for (var i =0; i < ss.length; i++) {
			document.getElementById("graph1OptionType").options[i] = new Option(ss[i], i);
  		}
	}
	function setgraph1OptionKind(s) {
		var ss = s.split(",");
		for (var i =0; i < ss.length; i++) {
			document.getElementById("graph1OptionKind").options[i] = new Option(ss[i], i);
  		}
	}
	function setgraph2Option(s) {
		var ss = s.split(",");
		for (var i =0; i < ss.length; i++) {
			document.getElementById("graph2Option").options[i] = new Option(ss[i], i);
  		}
	}
	function setgraph2OptionType(s) {
		var ss = s.split(",");
		for (var i =0; i < ss.length; i++) {
			document.getElementById("graph2OptionType").options[i] = new Option(ss[i], i);
  		}
	}
	function setgraph2OptionKind(s) {
		var ss = s.split(",");
		for (var i =0; i < ss.length; i++) {
			document.getElementById("graph2OptionKind").options[i] = new Option(ss[i], i);
  		}
	}
	function setgraphOptionStartDate() {
		var tmpDate;
		for (var i = 0; i < dataNum; i++) {
			tmpDate = jsonData["supplyDetail"][dataNum - i -1]["supplyDate"];
			document.getElementById("graphOptionStartDate").options[i] = new Option(tmpDate, tmpDate);
		}
	}
	
	function setgraphOptionEndDate() {
		var tmpDate;
		for (var i =0; i < dataNum; i++) {
			tmpDate = jsonData["supplyDetail"][i]["supplyDate"];
			document.getElementById("graphOptionEndDate").options[i] = new Option(tmpDate, tmpDate);
		}
	}
	
	function scanData() {
		stlCom.startDate = Date.parse(document.getElementById("graphOptionStartDate").value);
		stlCom.endDate = Date.parse(document.getElementById("graphOptionEndDate").value);

		stl[0].data = document.getElementById("graph1Option").value;
		stl[0].type = document.getElementById("graph1OptionType").value;
		stl[0].kind = document.getElementById("graph1OptionKind").value;
		stl[0].src = ((document.getElementById("graph1Option").value== "0") ? "bsMileage" :((document.getElementById("graph1Option").value== "1") ? "quantity":"totalPrice"));
		stl[0].max = 9999999.9;
		stl[0].min = 0;

		stl[1].data = document.getElementById("graph2Option").value;
		stl[1].type = document.getElementById("graph2OptionType").value;
		stl[1].kind = document.getElementById("graph2OptionKind").value;
		stl[1].src = ((document.getElementById("graph2Option").value== "0") ? "bsMileage" :((document.getElementById("graph2Option").value== "1") ? "quantity":"totalPrice"));
		stl[1].max = 9999999.9;
		stl[1].min = 0;
		
		setStyleDomain(0);
		setStyleDomain(1);
		
	}
	
	function drawGraph() {
		    if (setConditions() == false) {
		      return;
		    }
		    clearGraph(getBlur());
		    paintAxis();
		    paintGraph(0);
		    paintGraph(1);
	}

	function paintGraph(side) {
		var context = document.getElementById("gra").getContext('2d');
		var lastX = 0;
		var lastY = context.canvas.height;
		var workDate = 0;
		var workValue = 0.0;
		var isFirst = new Boolean(true);
		
		context.beginPath();
		if (stlCom.staInx == stlCom.endInx) {
			return;
		}
		for ( var i = stlCom.staInx; i >= stlCom.endInx; --i) {
			workDate = Date.parse(jsonData["supplyDetail"][i]["supplyDate"]);
			if (stl[side].type == "0") {
				workValue += parseFloat(jsonData["supplyDetail"][i][stl[side].src]);
			} else {
				workValue = parseFloat(jsonData["supplyDetail"][i][stl[side].src]);
			}
			lastX = context.canvas.width * (workDate - stlCom.startDate)
				/ (stlCom.endDate - stlCom.startDate);
			lastY = context.canvas.height * (stl[side].max - workValue)
				/ (stl[side].max -stl[side].min);
			context.lineWidth = 2;
			if (stl[side].kind == "0") {
				context.lineWidth = 4;
				context.moveTo(lastX, context.canvas.height);
			} else if (isFirst) {
				isFirst = false;
				context.moveTo(lastX, lastY);
			}
			context.lineTo(lastX, lastY);
		}
		context.strokeStyle = stl[side].color;
		context.stroke();
	}
	function paintAxis() {
		axisVer(0);
		axisVer(1);
		axisHrz();
	}
	
	function axisHrz() {
		var context = document.getElementById("horz").getContext('2d');
		var lastX = 0;
		var lastY = 0;
		var workDate = 0;
		var tempDate;
		var	ratch = 5;
		
		pitch = parseInt((stlCom.staInx - stlCom.endInx) / 6) + 1;
		context.lineWidth = 2;
		context.strokeStyle = "black";
		for (var i = stlCom.staInx - pitch; i > stlCom.endInx + pitch; i = i - pitch ) {
			tempDate = jsonData["supplyDetail"][i]["supplyDate"];
			workDate = Date.parse(tempDate);
			lastX = context.canvas.width * (workDate - stlCom.startDate)
					/ (stlCom.endDate - stlCom.startDate);			
			context.moveTo(lastX, lastY);
			context.lineTo(lastX, lastY + ratch);
			context.fillStyle = "black";
			context.fillText(tempDate, lastX, 20);
		}
		context.moveTo(0, 0);
		context.lineTo(context.canvas.width, 0);
		context.stroke();
	}
	
	function axisVer(side) {
		var context = document.getElementById("ver" + side).getContext('2d');
		var lastX = 0;
		var lastY = 0;
		var	ratch = 5;
		var n = 0;
		var m = 1;
		var p = 0;

		pitch = (stl[side].max - stl[side].min) / 6;
		p = pitch;
		for (var i = 0 ; p > 6; i++ ) {
			if (i % 2 == 1) {
				n = 5;
			} else { 
				n = 2;
			}
			m = m * n;
			p = parseInt(p / n);
		}
		pitch = p * m;
		pitchStart = parseInt(stl[side].min / pitch) * pitch;
		stl[side].min = pitchStart;
		pitchEnd = (parseInt(stl[side].max / pitch) + 1) * pitch;
		stl[side].max = pitchEnd;
		num = parseInt((pitchEnd - pitchStart) / pitch);
		lastX = (side == 0) ? context.canvas.width : 0;
		context.lineWidth = 2;
		context.strokeStyle = stl[side].color;
		for (var i = 1; i < num; i++ ) {
			lastY = context.canvas.height * (pitch * i / (pitchEnd - pitchStart));
			context.moveTo(lastX, lastY);
			context.lineTo(lastX + ratch * ((side == 0) ? (-1) : 1), lastY);
			context.fillStyle = stl[side].color;
			context.fillText((pitchEnd - pitch * i) + " " + stl[side].unit,
					10, lastY);
		}
		context.moveTo((side ==0) ? context.canvas.width : 0, 0);
		context.lineTo((side ==0) ? context.canvas.width : 0, context.canvas.height);
		context.stroke();
	}

	function setConditions() {
		if (((dataNum - document.getElementById("graphOptionStartDate").selectedindex -1)
				- document.getElementById("graphOptionEndDate").selectedindex) < 2) {
			alert("Invalid Date!");
			document.getElementById("graphOptionStartDate").value = lastStartDate;
			document.getElementById("graphOptionEndDate").value = lastEndDate;
			return false;
		}
		lastStartDate = document.getElementById("graphOptionStartDate").value;
		lastEndDate = document.getElementById("graphOptionEndDate").value;
		scanData();
		return true;
	}
	
	function clearGraph(isBlur) {
		var context = document.getElementById("gra").getContext('2d');
		var contextE = document.getElementById("ver0").getContext('2d');
		var contextW = document.getElementById("ver1").getContext('2d');
		var contextS = document.getElementById("horz").getContext('2d');
		var grad  = context.createLinearGradient(0,0, 0,context.canvas.height);
	    if (!isBlur) {
		 	context.fillStyle="rgba(255,255,255,1.0)";
		 	contextE.fillStyle="rgba(255,255,255,1.0)";
		 	contextW.fillStyle="rgba(255,255,255,1.0)";
		 	contextS.fillStyle="rgba(255,255,255,1.0)";
	        context.fillRect(0, 0, context.canvas.width, context.canvas.height);
	        contextE.fillRect(0, 0, contextE.canvas.width, contextE.canvas.height);
	        contextW.fillRect(0, 0, contextW.canvas.width, contextW.canvas.height);
	        contextS.fillRect(0, 0, contextS.canvas.width, contextS.canvas.height);
	    }
	 	context.fillStyle="rgba(90,90,0,0.1)";
	 	contextE.fillStyle="rgba(100,0,0,0.1)";
	 	contextW.fillStyle="rgba(0,100,0,0.1)";
	 	contextS.fillStyle="rgba(0,0,100,0.1)";
	    context.fillRect(0, 0, context.canvas.width, context.canvas.height);
	    contextE.fillRect(0, 0, contextE.canvas.width, contextE.canvas.height);
	    contextW.fillRect(0, 0, contextW.canvas.width, contextW.canvas.height);
	    contextS.fillRect(0, 0, contextS.canvas.width, contextS.canvas.height);
	}

	function decDateStart() {
		var i = 0;
		var j = 0;
		i = stlCom.staInx;
		j = stlCom.endInx;
		if (i == (dataNum - 1)) {
			return;
		}
		i = i + parseInt((i - j) / 3 + 0.4);
		i = ( i >= dataNum) ? dataNum -1 : i;
		stlCom.staInx = i;
		lastStartDate = jsonData["supplyDetail"][i]["supplyDate"];
		document.getElementById("graphOptionStartDate").value = lastStartDate;
		document.getElementById("graphOptionStartDate").focus();
		drawGraph(getBlur());
    }
	
	function incDateStart() {
		var i = 0;
		var j = 0;
		i = stlCom.staInx;
		j = stlCom.endInx;
		if ((i - j) < 3 ) {
			return;
		}
		i = i - parseInt((i - j) / 3 + 0.4);
		i = ((i - j) < 3 ) ? j + 2 : i;
		stlCom.staInx = i;
		lastStartDate = jsonData["supplyDetail"][i]["supplyDate"];
		document.getElementById("graphOptionStartDate").value = lastStartDate;
		document.getElementById("graphOptionStartDate").focus();
		drawGraph(getBlur());
	}

	function decDateEnd() {
		var i = 0;
		var j = 0;
		i = stlCom.staInx;
		j = stlCom.endInx;
		if ((i - j) < 3 ) {
			return;
		}
		j = j + parseInt((i - j) / 3 + 0.4);
		j = ((i - j) < 3 ) ? i - 2 : j;
		stlCom.endInx = j;
		lastEndDate = jsonData["supplyDetail"][j]["supplyDate"];
		document.getElementById("graphOptionEndDate").value = lastEndDate;
		document.getElementById("graphOptionEndDate").focus();
		drawGraph(getBlur());
	}
	
	function incDateEnd() {
		var i = 0;
		var j = 0;
		i = stlCom.staInx;
		j = stlCom.endInx;
		if (j == 0) {
			return;
		}
		j = j - parseInt((i - j) / 3 + 0.4);
		j = ( j < 0) ? 0 : j;
		stlCom.endInx = j;
		lastEndDate = jsonData["supplyDetail"][j]["supplyDate"];
		document.getElementById("graphOptionEndDate").value = lastEndDate;
		document.getElementById("graphOptionEndDate").focus();
		drawGraph(getBlur());
	}
	
	function setBlur(sw) {
		isBlur = sw;
	}

	function getBlur() {
		return isBlur;
	}
