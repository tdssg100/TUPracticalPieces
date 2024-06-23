
	function checkDigest(JsonStr) {
		if (JsonStr == null || JsonStr == "") {
			return false;
		}
        //20170430 replace &apos;
//		JsonStr.replace(/'/g, "&apos;");
//		document.getElementById("msgBox").innerHTML = document.getElementById("msgBox").innerHTML +  JsonStr;
//		document.getElementById("waitMsg").innerHTML = document.getElementById("waitMsg").innerHTML +  JsonStr;
		
		var locsArray = JSON.parse(JsonStr);
		var ret = new Boolean(locsArray["match"]);

		return ret;
	}
