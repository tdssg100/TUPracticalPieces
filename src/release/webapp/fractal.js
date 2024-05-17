	var gl;
	var shaderProgram;
	var triangleVertexPositionBuffer;
	var rTri = 0;
	var vertices;
	var	vInx;
	var	pInt;
	
	function childTri(level,p1,p2,p3) {
		vertices[vInx * 3 + 0] = p1[0];
		vertices[vInx * 3 + 1] = p1[1];
		vertices[vInx * 3 + 2] = p1[2];
		vertices[vInx * 3 + 3] = p2[0];
		vertices[vInx * 3 + 4] = p2[1];
		vertices[vInx * 3 + 5] = p2[2];
		vertices[vInx * 3 + 6] = p3[0];
		vertices[vInx * 3 + 7] = p3[1];
		vertices[vInx * 3 + 8] = p3[2];
		vInx += 3;
				
		if (level <= 0) {
			return;
		}
		level = level - 1;
		var	i;
		var pp1 = new Array();
		var pp2 = new Array();
		var pp3 = new Array();
		var pp4 = new Array();
		for (i = 0; i < 3; i++) {
			pp1[i] = ((p2[i] + p3[i])/2 + p1[i] * 2) /3;
		}
		for (i = 0; i < 3; i++) {
			pp2[i] = ((p3[i] + p1[i])/2 + p2[i] * 2) /3;
		}
		for (i = 0; i < 3; i++) {
			pp3[i] = ((p1[i] + p2[i])/2 + p3[i] * 2) /3;
		}
		var a = new Array(pp2[0]-pp1[0],pp2[1]-pp1[1],pp2[2]-pp1[2]);
		var b = new Array(pp3[0]-pp1[0],pp3[1]-pp1[1],pp3[2]-pp1[2]);		
		var proj = new Array(a[1] * b[2] - a[2] * b[1] , a[2] * b[0] - a[0] * b[2], a[0] * b[1] - a[1] * b[0]);
		var r = Math.sqrt(proj[0] * proj[0] + proj[1] * proj[1] + proj[2] * proj[2])
		var s = Math.sqrt(a[0] * a[0] + a[1] * a[1] + a[2] * a[2]);
		for (i = 0; i < 3; i++ ) {
			pp4[i] = (pp1[i] + pp2[i] + pp3[i]) / 3 + s * Math.sin(Math.acos(1 / 3)) * Math.sqrt(3) / 2 * proj[i] / r;
		}
		childTri(level,pp1,pp2,pp4);
		childTri(level,pp2,pp3,pp4);
		childTri(level,pp3,pp1,pp4);		

	}

	function initGl() {
		// GL
		var canvas = document.getElementById("gra");
//		initGL(canvas);
		try {
			gl = canvas.getContext("webgl"); //webgl"experimental-webgl"moz-glweb20
		} catch(e) {
			gl = null;
		}
		if (!gl) {
			try {
				gl = canvas.getContext("experimental-webgl"); //webgl"experimental-webgl"moz-glweb20
			} catch(e) {
				gl = null;
			}
		}
		if (!gl) {
			alert("Could not initialise WebGL because of no support for webgl of browser, otherwise no GPU, out of memory, etc.");
			return false;
		}
		gl.viewportWidth = canvas.width;
		gl.viewportHeight = canvas.height;


//		initShaders();
		var fragmentShader = getShader(gl, "shader-fs");
		var vertexShader = getShader(gl, "shader-vs");

		shaderProgram = gl.createProgram();
		gl.attachShader(shaderProgram, vertexShader);
		gl.attachShader(shaderProgram, fragmentShader);
		gl.linkProgram(shaderProgram);

		if (!gl.getProgramParameter(shaderProgram, gl.LINK_STATUS)) {
			alert("Could not initialise shaders");
			return false;
		}

		gl.useProgram(shaderProgram);
		shaderProgram.vertexPositionAttribute = gl.getAttribLocation(shaderProgram, "aVertexPosition");
		gl.enableVertexAttribArray(shaderProgram.vertexPositionAttribute);

		shaderProgram.vertexColorAttribute = gl.getAttribLocation(shaderProgram, "aVertexColor");
		gl.enableVertexAttribArray(shaderProgram.vertexColorAttribute);

		shaderProgram.pMatrixUniform = gl.getUniformLocation(shaderProgram, "uPMatrix");
		shaderProgram.mvMatrixUniform = gl.getUniformLocation(shaderProgram, "uMVMatrix");
		return true;
	}
	
	function modeling(level) {
//		initBuffers();
		var	edge = 3;
		var	p1;
		var	p2;
		var	p3;
		var	p4;

//		if (pInt) {
//			clearInterval(pInt);
//		}
			
		p1 = new Array(0.0,				Math.sqrt(3) * edge /2,			0.0);
		p2 = new Array(-0.5 * edge,	0.0,									0.0);
		p3 = new Array(0.5 * edge,	0.0,									0.0);
		p4 = new Array(0.0,				edge /3,							

	(Math.sqrt(3) * edge * Math.sin(Math.acos(1 / 3))/2)); 
		triangleVertexPositionBuffer = gl.createBuffer();
		gl.bindBuffer(gl.ARRAY_BUFFER, triangleVertexPositionBuffer);
//		level = document.getElementById("selectGraph0").value;
		vInx = 0;
		vertices = new Array();
		childTri(level, p1,p3,p2);
		childTri(level, p2,p3,p4);
		childTri(level, p3,p1,p4);
		childTri(level, p4,p1,p2);
		
		gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertices), gl.STATIC_DRAW);

//		triangleVertexPositionBuffer.itemSize = 3;
//		triangleVertexPositionBuffer.numItems = vInx;
		//triangleVertexPositionBuffer['itemSize'] = 3;
		//triangleVertexPositionBuffer['numItems'] = vInx;
		triangleVertexPositionBuffer.itemSize = 3;
		triangleVertexPositionBuffer.numItems = vInx;

		triangleVertexColorBuffer = gl.createBuffer();
		gl.bindBuffer(gl.ARRAY_BUFFER, triangleVertexColorBuffer);
		var colors = new Array(vInx * 4);
		var rateCol = document.getElementById('rangeRotation').value / 90;
		var mainColor = Math.cos(Math.PI / 2 * rateCol);
		var subColor = Math.sin(Math.PI / 2 * rateCol);

		for (var i = 0; i < (vInx +1) * 4; i++) {
			j = i - parseInt(i/4) * 4;
			k = parseInt(i/4) - parseInt(parseInt(i/4)/3) * 3;
			if (j == 3) {
				colors[i] = 1.0;
			} else if (j == k) {
				colors[i] = mainColor;
			} else {
				colors[i] = subColor;
			}
	   }
		gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(colors), gl.STATIC_DRAW);
//		triangleVertexColorBuffer.itemSize = 4;
//		triangleVertexColorBuffer.numItems = vInx;
		//triangleVertexColorBuffer['itemSize'] = 4;
		//triangleVertexColorBuffer['numItems'] = vInx;
		triangleVertexColorBuffer.itemSize = 4;
		triangleVertexColorBuffer.numItems = vInx;


		gl.clearColor(0.5, 0.5, 0.5, 1.0);
		gl.clearDepth(1.0)
		gl.enable(gl.DEPTH_TEST);
		gl.depthFunc(gl.LEQUAL);


		lastTime = new Date().getTime();
//		pInt=setInterval(tick, 200);
//		tick();
	}

	function getShader(gl, id) {
//			var shaderScript = document.getElementById(id);
//			if (!shaderScript) {
//					return null;
//			}
//
//			var str = "";
//			var k = shaderScript.firstChild;
//			while (k) {
//					if (k.nodeType == 3)
//							str += k.textContent;
//					k = k.nextSibling;
//			}

			var shader;
			var str = "";

			if (id == "shader-fs") { 
			  str ="#ifdef GL_ES" + "\n" +
				  	"	precision highp float;" + "\n" + 
			  		"#endif"  + "\n" + "\n" + 
			  		"	varying vec4 vColor;" + "\n" + "\n" +
			  		"	void main(void) {" + "\n" +
			  		"		gl_FragColor = vColor;" + "\n" +
			  		"	}";
			 
			  		// if (shaderScript.type == "x-shader/x-fragment") {
					shader = gl.createShader(gl.FRAGMENT_SHADER);
			} else { // "shader-vs"
				  str ="	attribute vec3 aVertexPosition;" + "\n" +
				  	"	attribute vec4 aVertexColor;" + "\n" + "\n" +
			  		"	uniform mat4 uMVMatrix;" + "\n" + 
			  		"	uniform mat4 uPMatrix;" + "\n" + "\n" +
			  		"	varying vec4 vColor;" + "\n" + "\n" +
			  		"	void main(void) {" + "\n" +
			  		"		gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);" + "\n" +
			  		"		vColor = aVertexColor;" + "\n" +
			  		"	}";
			 
			        //} else if (shaderScript.type == "x-shader/x-vertex") {
					shader = gl.createShader(gl.VERTEX_SHADER);
			}

			gl.shaderSource(shader, str);
			gl.compileShader(shader);

			if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS)) {
					alert(gl.getShaderInfoLog(shader));
					return null;
			}

			return shader;
	}
	
//	
//	function tick() {
//		drawScene();
//		animate();
//	}
//
//	var lastTime = 0;
//	function animate() {
//		var timeNow = new Date().getTime();
//		if (lastTime != 0) {
//			var elapsed = timeNow - lastTime;
//
//			rTri += (90 * elapsed) / 1000.0;
//		}
//		c = timeNow;
//	}
//	
	
	function drawScene() {
	 rTri += parseInt(document.getElementById('rangeRotation').value);
	 gl.viewport(0, 0, gl.viewportWidth, gl.viewportHeight);
		gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

		perspective(45, gl.viewportWidth / gl.viewportHeight, 0.1, 100.0);
		loadIdentity();

//		mvTranslate([-1.5, 0.0, -7.0])
		mvTranslate([0.0, 0.0, -7.0])

		mvPushMatrix();
		mvRotate(rTri, [0, 1, 0]);

		gl.bindBuffer(gl.ARRAY_BUFFER, triangleVertexPositionBuffer);
		//gl.vertexAttribPointer(shaderProgram.vertexPositionAttribute, 
		//	triangleVertexPositionBuffer['itemSize'], gl.FLOAT, false, 0, 0);
		gl.vertexAttribPointer(shaderProgram.vertexPositionAttribute, 
		triangleVertexPositionBuffer.itemSize, gl.FLOAT, false, 0, 0);

		gl.bindBuffer(gl.ARRAY_BUFFER, triangleVertexColorBuffer);
		//gl.vertexAttribPointer(shaderProgram.vertexColorAttribute,
		//		triangleVertexColorBuffer['itemSize'], gl.FLOAT, false, 0, 0);
		gl.vertexAttribPointer(shaderProgram.vertexColorAttribute,
				triangleVertexColorBuffer.itemSize, gl.FLOAT, false, 0, 0);

		setMatrixUniforms();
		//gl.drawArrays(gl.TRIANGLES, 0, triangleVertexPositionBuffer['numItems']);
		gl.drawArrays(gl.TRIANGLES, 0, triangleVertexPositionBuffer.numItems);
		mvPopMatrix();
 
	}

	
	var mvMatrix;

	function loadIdentity() {
		mvMatrix = Matrix.I(4);
	}

	function multMatrix(m) {
		mvMatrix = mvMatrix.x(m);
	}

	function mvTranslate(v) {
		var m = Matrix.Translation($V([v[0], v[1], v[2]])).ensure4x4();
		multMatrix(m);
	}


	var pMatrix;
	function perspective(fovy, aspect, znear, zfar) {
		pMatrix = makePerspective(fovy, aspect, znear, zfar);
	}


	var mvMatrixStack = [];

	function mvPushMatrix(m) {
		if (m) {
			mvMatrixStack.push(m.dup());
			mvMatrix = m.dup();
		} else {
			mvMatrixStack.push(mvMatrix.dup());
		}
	}

	function mvPopMatrix() {
		if (mvMatrixStack.length == 0) {
			throw "Invalid popMatrix!";
		}
		mvMatrix = mvMatrixStack.pop();
		return mvMatrix;
	}
	function mvRotate(ang, v) {
		var arad = ang * Math.PI / 180.0;
		var m = Matrix.Rotation(arad, $V([v[0], v[1], v[2]])).ensure4x4();
		multMatrix(m);
	}

  function setMatrixUniforms() {
    gl.uniformMatrix4fv(shaderProgram.pMatrixUniform, false, new Float32Array(pMatrix.flatten()));
    gl.uniformMatrix4fv(shaderProgram.mvMatrixUniform, false, new Float32Array(mvMatrix.flatten()));
  }
  
  function reverseR(b) {
	  return (b==0) ? 1 : 0;
  }
  
  function changeRotation() {
      var el = document.getElementById('rangeRotation').value;
      document.getElementById('rangeRotationValue').innerHTML = el;
  }

  function changeInterval() {
      var el = document.getElementById('rangeInterval').value;
      document.getElementById('rangeIntervalValue').innerHTML = el;
  }

  function changeRecursiveLevel() {
      var el = document.getElementById('rangeRecursiveLevel').value;
      var lvl = parseInt(el);
      var pols = 4;
      var bn = 4;
      var i;
      for (i = 0; i < lvl; i++) {
    	  pols += bn * 3;
    	  bn *= 3;
      }
      document.getElementById('rangeRecursiveLevelValue').innerHTML = el;
      document.getElementById('polygonNum').innerHTML = pols;
  }

  function getInterval() {
      return parseInt(document.getElementById('rangeInterval').value);
  }

  function getRecursiveLevel() {
      return parseInt(document.getElementById('rangeRecursiveLevel').value);
  }
  