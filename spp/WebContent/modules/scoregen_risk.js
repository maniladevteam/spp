var param_prodfam = "('Investors','Xtra/Eikon','Transactions','Other Products/Sunset','Datascope')";
var param_languagectr = "('Gdynia German','Gdynia Other','Geneva','Latam','Nicosia','Greater China','Sydney','Japan')";
var param_specialist = "('Investors Specialists','Trading & Market Places Specialists')";
var param_risk = "('Investors Specialists','Trading & Market Places Specialists')";
var prodfamlc = "RISK";
var param_global_workgroup = "";
var param_serialno = "";

	$(document).ready(function() {
	
					$("#preload").hide();
				
					GetUserInfo($("#uidlogged").val());					
					GetViewYear(4, '', ''); 
					GetUpdateDate('','');
					
					$("#filter_view").change(function() {

						var selectedview = this.value;

						if (selectedview == '1') {

							GetViewFreq(1, $("#yearno").val(),'');
							$("#filter_freq").show();

						} else if (selectedview == '2') {

							GetViewFreq(2, $("#yearno").val(),'');
							$("#filter_freq").show();

						} else if (selectedview == '3') {

							GetViewFreq(3, $("#yearno").val(),'');
							$("#filter_freq").show();

						} else if (selectedview == '4') {

							GetViewFreq(4, $("#yearno").val(),'');
							$("#filter_freq").hide();

						}

					});

					
					$("#filter_view_rawmodal").change(function() {

						var selectedview = this.value;

						if (selectedview == '1') {

							GetViewFreq(1, $("#yearno").val(),'rawmodal');
							$("#filter_freq_rawmodal").show();

						} else if (selectedview == '2') {

							GetViewFreq(2, $("#yearno").val(),'rawmodal');
							$("#filter_freq_rawmodal").show();

						} else if (selectedview == '3') {

							GetViewFreq(3, $("#yearno").val(),'rawmodal');
							$("#filter_freq_rawmodal").show();

						} else if (selectedview == '4') {

							GetViewFreq(4, $("#yearno").val(),'rawmodal');
							$("#filter_freq_rawmodal").hide();

						}

					});

					$("#yearno").change(function() {
						GetViewFreq($("#filter_view").val(), $("#yearno").val(),'');						
					});

					$("#freqno").change(function() {							
							RunScore($("#filter_view").val(), $("#yearno").val());
					});
					
					$("#yearno_rawmodal").change(function() {
						GetViewFreq($("#filter_view_rawmodal").val(), $("#yearno_rawmodal").val(),'rawmodal');						
					});

					$("#extractrawdatabut").click(function() {							
							GetSppRawData($("#filter_view_rawmodal").val(), "Risk", $("#freqno_rawmodal").val(), $("#yearno_rawmodal").val());
							
					});					
					
					$("#rawdatabut").click(function() {
						
						$("#SppRawData").modal('show');	
						$("#preloadcube").hide(); 
				
					}); 
					
					$("#downloadraw").click(function() {
						
						GetHdRaw();

					}); 	

					$('#SppRawData').on('shown.bs.modal', function () {

						GetViewYear(4, '', 'rawmodal'); 
					});
					
					$('#SppRawData').on('hidden.bs.modal', function () {
						$('#rawdatatab').dataTable().fnDestroy();  // Destroy
																	// Data
																	// Table
						$("#rawdatabody").html("");
					});
					
					$('#rawdataverbatim').on('shown.bs.modal', function () {
						ViewVerbatimDetails(param_serialno);
						
					});
					
					$(document).on('change','input:radio[id^="prodlc_radio"]',function(event) {
						
						if ($("input[name=prodlc_radio]:checked").val() == "prodfam") {
							prodfamlc = param_prodfam;
						} else if ($("input[name=prodlc_radio]:checked").val() == "languagectr") {
							prodfamlc = param_languagectr;
						}else if ($("input[name=prodlc_radio]:checked").val() == "specialist") {
							prodfamlc = param_specialist;
						}

						GetProdLcSppScore_list($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(),prodfamlc, "prodfam");
						GetProdLcSppScore_TimeBucket($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc, "prodfam");
					});
					
					$('#prodlcdetails_modal').on('shown.bs.modal', function () {

						GetProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
						GetDetractSupportProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
						GetFactorBucketsProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
						GetWgScore_TimeBucket($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
						GetWgSppScore_list($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
						
					});
					
					$('#wgdetails_modal').on('shown.bs.modal', function () {

						GetWgSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), param_global_workgroup);
						GetDetractSupportWgSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), param_global_workgroup);						
						GetFactorBucketsWgSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), param_global_workgroup);
						GetAgScore_TimeBucket($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), param_global_workgroup);
						GetAgSppScore_list($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), param_global_workgroup);
						
					});
					

			        $('#starttour').click(function () {
			        	TourMe();
			        });
			        $('#tourmodal').click(function () {
			        	TourMe();
			        });
			        
			       
			    	$('#disableintro').click(function () {
			    		GetUserIntroDisable($("#uidlogged").val(),"1");
					});
				   
			       
				});

function TourMe(){
	$('#intromodal').modal('hide');
	var tour = new Tour({
		steps : [ {
			element : "#mainscorebox",
			title : "Overall Score",
			content : "Contains previous and current score for top box 2 and 4. Also shows score trend chart. ",
			backdrop: true
		}, {
			element : "#scorebreakdownscore",
			title : "Score Breakdown",
			content : "Score distribution percentage for Supporter, Positive, Negative and Detractors. It shows client sentiments towards support",
			backdrop: true
		}, {
			element : "#factorbucketsscore",
			title : "Contributing Factors",
			content : "Scores distributions for factors affecting the customers",
			backdrop: true
		}, {
			element : "#timelinessbucketscore",
			title : "Timeliness Buckets",
			content : "Scores distribution base on their time to close by Product Family or Language Centers",
			backdrop: true
		}, {
			element : "#functionscore",
			title : "Function Score Summary",
			content : "Contains previous and current score for top box 2 and 4 per Product Family or Language Centers. Click on each line to drill down up to agent level",
			backdrop: true
		}, {
			element : "#userprofile",
			title : "Profile Panel",
			content : "Contains user information and gamefication score. Future upgrade will allow users to upload profile pictures and earn badges",
			backdrop: false
		}, {
			element : "#filters",
			title : "View Filters",
			content : "You can select filters to customize the view of the dashboards",
			backdrop: false
		}, {
			element : "#rawdatabut",
			title : "Raw Data View",
			content : "Here you can view basic survey information and extract raw data in .xls format",
			backdrop: false
		}   
		],
		
	});
		 tour.init();
		 tour.restart();
}
	

function SelectView(view,type) {

	var selectview = "";
	var selectviewchart = ""
	
	switch (parseInt(view)) {

	case 1:
		selectview = "monthscore";
		selectviewchart = "monthscorechart";
		
		break;

	case 2:
		selectview = "weekscore";
		selectviewchart = "weekscorechart";
		
		break;

	case 3:
		selectview = "quarterscore";
		selectviewchart = "quarterscorechart";
		
		break;

	case 4:
		selectview = "yearscore";
		selectviewchart = "yearscorechart";
		break;

	}

	if(type === 1){
		return selectview;
	}else{
		return selectviewchart;
	}
	
}

function ProdFamValue(){
	
	var prodfamvalue = "";
	
	if (prodfamlc == "" || prodfamlc == "undefined" || prodfamlc == undefined) {

		prodfamvalue = param_prodfam;
	} else {
		prodfamvalue = prodfamlc;
	}
	
	return prodfamvalue;
}

function ScorePassFail(score) {

	var color = "";
	var target = 70;

	if (score >= target) {
		color = 'text-success';
	} else if (score < target) {
		color = 'text-danger';
	}

	return color;
}

function ArrowUpDown(current, previous, setreturn) {

	var arrow = "";
	var color = "";
	var target = 70;

	if (current >= previous) {
		arrow = 'fa-level-up';
		color = 'text-success';
	} else if (current < previous) {
		arrow = 'fa-level-down';
		color = 'text-danger';
	} else if (current = previous) {
		arrow = '';
		color = '';
	}

	if (setreturn == 1) {
		return arrow;
	} else {
		return color;
	}

}

function ZeroDivide(numup, numdown) {

	metric = numup;

	if (numup == null || numup == "undefined" || numup == undefined
			|| numup == "0" || numup == 0) {
		metric = 0;
	} else {
		metric = (numup / numdown)
	}

	return metric;
}

function NoUndefine(value) {

	newVal = value;

	if (value == null || value == "undefined" || value == undefined|| value == "0" || value == 0) {
		newVal = 0;
	} else {
		newVal = value
	}

	return newVal;
}

function MonthTextValue(monthno) {

	var monthtext = "";
	
	switch (monthno) {

	case 1: 		
		monthtext = "January"; 
		break;
	
	case 2: 		
		monthtext = "February";
		break;
	
	case 3: 	
		monthtext = "March"; 
		break;
	
	case 4: 		
		monthtext = "April"; 
		break;
	
	case 5: 	
		monthtext = "May"; 
		break;
	
	case 6: 		
		monthtext = "June"; 
		break;
	
	case 7: 	
		monthtext = "July"; 
		break;
	
	case 8: 			
		monthtext = "August"; 
		break;
	
	case 9: 
		monthtext = "September"; 
		break;
	
	case 10: 
		monthtext = "October"; 
		break;
	
	case 11: 
		monthtext = "November"; 
		break;
	
	case 12: 
		monthtext = "December"; 
		break;

	}

	return monthtext;
}

function GetUserInfo(param_userid) {

	var i = 0;
	
	$("#user_name").html("");
	$("#user_role").html("");
	
	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/userinfo",
		data : "{\"param_userid\":" + '"' + param_userid + '"}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			

			var dataTable = "";
			var dataTable2 = "";

				dataTable = resultsArray[0].name;
				dataTable2 = resultsArray[0].groupname;
				

			$("#user_name").append(dataTable);
			$("#user_role").append(dataTable2);

		},
		complete : function(e) {
	
			GetUserAuditLog($("#uidlogged").val(), $("#user_role").text(), "admin page", $("#user_name").text(),'1');
		}

	});
}

function GetUserAuditLog(param_userid, param_role, param_fxnexec, param_name,onload) {

	var i = 0;

	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/userauditlog",
		data : "{\"param_userid\":" + '"' + param_userid
		+ "\",\"param_role\":" + '"' + param_role
		+ "\",\"param_fxnexec\":" + '"' + param_fxnexec
		+ "\",\"param_name\":" + '"' + param_name
		+ '"}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

		},complete : function(e){
			if(onload == '1'){
				GetUserIntroinfo($("#uidlogged").val());
			}
		}

	});
}


function GetUserIntroinfo(param_userid) {
	$("#rawdataverbatifm").show();
	var i = 0;
	var introvalue = "";
	var dataTable = "";
	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/userintroinfo",
		data : "{\"param_userid\":" + '"' + param_userid + '"}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			

			introvalue = resultsArray[0].intro;
	
		},
		complete : function(e) {

			if(introvalue != "1"){
				$('#intromodal').modal({show: true, backdrop: 'static', keyboard: false});
				$("#disableintro").show();
			}else{
				$("#disableintro").hide();
			}
		}

	});
}

function GetUserIntroDisable(param_userid, param_intro) {
	
	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/userintrodisable",
		data : "{\"param_userid\":" + '"' + param_userid
		+ "\",\"param_intro\":" + '"' + param_intro
		+ '"}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

		}

	});
}




function GetUpdateDate(param_view, param_yearno) {

	var i = 0;

	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/sppupdatedate",
		data : "{\"param_view\":" + '"' + param_view
				+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			$("#updatedate").html("");

			var dataTable = "";

				dataTable = dataTable +  "<span class='pull-right'><!-- Note from the main chart box --></span> Last Update : " +resultsArray[0].updatedate;
				

			$("#updatedate").append(dataTable);

		}

	});
}



function GetViewYear(param_view, param_yearno, fxn) {

	var i = 0;
	var container = "";
	
	if(fxn != 'rawmodal'){
		container = "yearno";
	}else{
		container = "yearno_rawmodal";
	}
	
	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/viewfreq",
		data : "{\"param_view\":" + '"' + SelectView(param_view,1)
				+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
					
			$("#" + container).html("");

			var dataTable = "";

			for (var i = 0; i < resultsArray.length; i++) {

				dataTable = dataTable + "<option>" + resultsArray[i].freqno+ "</option>";
			}
			
				$("#"+container).append(dataTable);

		},
		complete : function(e) {

			GetViewFreq(1, $("#"+container).val(), fxn); 
		}

	});
}

function GetViewFreq(param_view, param_yearno, fxn) {

	

	var i = 0;
	var label = "";
	var prodfamvalue = "";
	var container = "";
	var container_label = "";
	
	
	if(fxn != 'rawmodal'){		
		container = "freqno";
		container_label ="freqno_label";
	}else{
		container = "freqno_rawmodal";
		container_label ="freqno_label_rawmodal";

	}
	
	$("#"+container_label).html("");
	
	if (param_view == '1') { 
		label = "Month"
	} else if (param_view == '2') {
		label = "Week"
	} else if (param_view == '3') {
		label = "Quarter"
	} else if (param_view == '4') {
		label = "Year"
	}

	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/viewfreq",
		data : "{\"param_view\":" + '"' + SelectView(param_view,1)
				+ "\",\"param_yearno\":" + '"' + param_yearno + '"	}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			$("#"+container).html("");

			var dataTable = "";
			var dataTable2 = label;

			for (var i = 0; i < resultsArray.length; i++) {

				dataTable = dataTable + "<option>" + resultsArray[i].freqno+ "</option>";
			}

				$("#"+container).append(dataTable);
				$("#"+container_label).append(dataTable2);

		},
		complete : function(e) {
			if(fxn != 'rawmodal'){
				RunScore(param_view, param_yearno);
			}	
			
		}

	});

}


function RunScore(param_view, param_yearno){
	
	GetProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc)
	GetWgSppScore_list($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
	GetWgScore_TimeBucket($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
	GetDetractSupportProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
	GetFactorBucketsProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
	GetOverallSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val());

	/*GetProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
	GetDetractSupportProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
	GetFactorBucketsProdLcSppScore($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
	GetWgScore_TimeBucket($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);
	GetWgSppScore_list($("#filter_view").val(), $("#freqno").val(), $("#yearno").val(), prodfamlc);*/

}


// ///////////////////////////////ModalFunctionsTriggers

function RunScoreProdLc(prodlcname){
	prodfamlc = prodlcname
	 $("#prodlcdetails_modal").modal('show')
	
}


function GetOverallSppScore(param_view, param_freqno, param_yearno) {
	 
	var tp2allscore = "";
	var tp4allscore = "";
	var pre_tp2allscore = "";
	var pre_tp4allscore = "";
	var pre_tp2allscore_chart = [];
	var pre_tp4allscore_chart = [];
	var pre_tp2allscore_chartlabel = [];
	
	GetSppScore_Cur(param_view, param_freqno, param_yearno);

	function GetSppScore_Cur(param_view, param_freqno, param_yearno) {

		var previous_freqno = param_freqno - 1;

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscore",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

				tp2allscore = ZeroDivide(resultsArray[0].tp2_currentcm_count,resultsArray[0].tp2_currentcm_total);
				tp4allscore = ZeroDivide(resultsArray[0].tp4_currentcm_count,resultsArray[0].tp4_currentcm_total);

			},
			complete : function(e) {

				GetSppScore_Pre(param_view, previous_freqno,param_yearno)
			}

		});
	}

	function GetSppScore_Pre(param_view, param_freqno, param_yearno) {

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscore",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

				pre_tp2allscore = ZeroDivide(resultsArray[0].tp2_currentcm_count,resultsArray[0].tp2_currentcm_total);
				pre_tp4allscore = ZeroDivide(resultsArray[0].tp4_currentcm_count,resultsArray[0].tp4_currentcm_total);

			},complete : function(e) {

				RenderSppScore()
				GetSppScore_Chart_Cur(param_view, param_freqno, param_yearno)
			}

		});
	}
	
	function GetSppScore_Chart_Cur(param_view, param_freqno, param_yearno) {

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscore",
			data : "{\"param_view\":" + '"' + SelectView(param_view,2)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno
					+ '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

						for (var i = 0; i < resultsArray.length; i++) {
							
							pre_tp2allscore_chart.push((ZeroDivide(resultsArray[i].tp2_currentcm_count,resultsArray[i].tp2_currentcm_total)*100).toFixed(0));
							pre_tp4allscore_chart.push((ZeroDivide(resultsArray[i].tp4_currentcm_count,resultsArray[i].tp4_currentcm_total)*100).toFixed(0));
							if(param_view == 1){
								
								pre_tp2allscore_chartlabel.push(MonthTextValue(resultsArray[i].freqno).substring(3, 0));
							}else{
								
								pre_tp2allscore_chartlabel.push(resultsArray[i].freqno);
							}
						}
						
			},
			complete : function(e) {
				 RenderChartJsData();
			}

		});
	}
	
	function RenderChartJsData (){
		
		$("#overallscorechart_box").html("");
		var myNewChart = "";
		
		var lineData = {
		        labels: pre_tp2allscore_chartlabel,
		        datasets: [
		                   
		                   {
		                       label: "Example dataset",
		                       fillColor: "rgba(98,203,49,0.5)",		                       
		                       strokeColor: "rgba(98,203,49,0.7)",
		                       pointColor: "rgba(98,203,49,1)",
		                       pointStrokeColor: "#fff",
		                       pointHighlightFill: "#fff",
		                       pointHighlightStroke: "rgba(26,179,148,1)",
		                       data: pre_tp2allscore_chart
		                   },
		                   {
		                       label: "Example dataset",
		                       fillColor: "rgba(220,220,220,0.5)",
		                       strokeColor: "rgba(220,220,220,1)",
		                       pointColor: "rgba(220,220,220,1)",		                       
		                       pointStrokeColor: "#fff",
		                       pointHighlightFill: "#fff",
		                       pointHighlightStroke: "rgba(220,220,220,1)",		                       
		                       data: pre_tp4allscore_chart
		                   }
		        ]
		    };

		    var lineOptions = {
		        scaleShowGridLines : true,
		        scaleGridLineColor : "rgba(0,0,0,.05)",
		        scaleGridLineWidth : 1,
		        bezierCurve : true,
		        bezierCurveTension : 0.4,
		        pointDot : true,
		        pointDotRadius : 4,
		        pointDotStrokeWidth : 1,
		        pointHitDetectionRadius : 20,
		        datasetStroke : true,
		        datasetStrokeWidth : 1,
		        datasetFill : true,
		        responsive: true
		    };
		   
		    var dataTable = "<canvas id='overallscorechart' height='80'></canvas>";		    
		    $("#overallscorechart_box").append(dataTable);
		  
		    var ctx = document.getElementById("overallscorechart").getContext("2d");
		    myNewChart = new Chart(ctx).Line(lineData, lineOptions);		    	
	}

	function RenderSppScore() {

		$("#overeallscore_box").html("");

		var dataTable = "";

		dataTable = dataTable + "<div class='col-lg-6 text-center m-t-xs'>";
		dataTable = dataTable + "<div class='row'><small class='stat-label font-bold'>Top Box 2</small></div>";
		dataTable = dataTable + "<div class='row m-l-xs'><div class='col-md-4'><h1 class='no-margins font-bold " + ScorePassFail((tp2allscore * 100).toFixed(0)) + " '>" + (tp2allscore * 100).toFixed(0) + "</h1></div>";
		dataTable = dataTable + "<div class='col-md-6 m-t-xs m-l-md'><h4 >"+ (pre_tp2allscore * 100).toFixed(0) + " <i class='fa "+ ArrowUpDown((tp2allscore * 100).toFixed(0),(pre_tp2allscore * 100).toFixed(0), 1)+ " "+ ScorePassFail((tp2allscore * 100).toFixed(0),(pre_tp2allscore * 100).toFixed(0), 2) + "'></i></h4></div>";
		dataTable = dataTable + "</div></div>"
		dataTable = dataTable + "<div class='col-lg-6 text-center m-t-xs'>";
		dataTable = dataTable + "<div class='row'><small class='stat-label font-bold'>Top Box 4</small></div>";
		dataTable = dataTable + "<div class='row m-l-xs'><div class='col-md-4'><h1 class='no-margins font-bold "+ ScorePassFail((tp4allscore * 100).toFixed(0)) + " '>"+ (tp4allscore * 100).toFixed(0) + "</h1></div>";
		dataTable = dataTable + "<div class='col-md-6 m-t-xs m-l-md'><h4 >" + (pre_tp4allscore * 100).toFixed(0) + " <i class='fa " + ArrowUpDown((tp4allscore * 100).toFixed(0),(pre_tp4allscore * 100).toFixed(0), 1) + " " + ArrowUpDown((tp4allscore * 100).toFixed(0), (pre_tp4allscore * 100).toFixed(0), 2) + "'></i></h4></div>";
		dataTable = dataTable + "</div></div>"

		$("#overeallscore_box").append(dataTable);

	}

}



function GetProdLcSppScore(param_view, param_freqno, param_yearno, param_prodlc) {
	 
	var tp2allscore = "";
	var tp4allscore = "";
	var pre_tp2allscore = "";
	var pre_tp4allscore = "";
	var pre_tp2allscore_chart = [];
	var pre_tp4allscore_chart = [];
	var pre_tp2allscore_chartlabel = [];
	var totalsurveys = "";
	
	
	GetProdLcSppScore_Cur(param_view, param_freqno, param_yearno, param_prodlc);

	function GetProdLcSppScore_Cur(param_view, param_freqno, param_yearno, param_prodlc) {

		var previous_freqno = param_freqno - 1;

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscoreprodlc",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_prodlc\":" + '"' + param_prodlc
					+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

				tp2allscore = ZeroDivide(resultsArray[0].tp2_currentcm_count,resultsArray[0].tp2_currentcm_total);
				tp4allscore = ZeroDivide(resultsArray[0].tp4_currentcm_count,resultsArray[0].tp4_currentcm_total);
				totalsurveys = resultsArray[0].total_surveys;

			},
			complete : function(e) {

				GetProdLcSppScore_Pre(param_view, previous_freqno,param_yearno, param_prodlc)
			}

		});
	}

	function GetProdLcSppScore_Pre(param_view, param_freqno, param_yearno, param_prodlc) {

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscoreprodlc",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_prodlc\":" + '"' + param_prodlc
					+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

				pre_tp2allscore = ZeroDivide(resultsArray[0].tp2_currentcm_count,resultsArray[0].tp2_currentcm_total);
				pre_tp4allscore = ZeroDivide(resultsArray[0].tp4_currentcm_count,resultsArray[0].tp4_currentcm_total);

			},complete : function(e) {

				RenderProdLcSppScore()
				GetProdLcSppScore_Chart_Cur(param_view, param_freqno, param_yearno, param_prodlc)
			}

		});
	}
	
	function GetProdLcSppScore_Chart_Cur(param_view, param_freqno, param_yearno, param_prodlc) {

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscoreprodlc",
			data : "{\"param_view\":" + '"' + SelectView(param_view,2)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno
					+ "\",\"param_prodlc\":" + '"' + param_prodlc
					+ '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

						for (var i = 0; i < resultsArray.length; i++) {
							
							pre_tp2allscore_chart.push((ZeroDivide(resultsArray[i].tp2_currentcm_count,resultsArray[i].tp2_currentcm_total)*100).toFixed(0));
							pre_tp4allscore_chart.push((ZeroDivide(resultsArray[i].tp4_currentcm_count,resultsArray[i].tp4_currentcm_total)*100).toFixed(0));
							pre_tp2allscore_chartlabel.push(resultsArray[i].freqno);
						}
						
			},
			complete : function(e) {
				 RenderChartJsData();
			}

		});
	}
	
	function RenderChartJsData (){
		
		$("#content_overallscorechart_box").html("");
		var myNewChart = "";
		
		var lineData = {
		        labels: pre_tp2allscore_chartlabel,
		        datasets: [
		                   
		                   {
		                       label: "Example dataset",
		                       fillColor: "rgba(98,203,49,0.5)",		                       
		                       strokeColor: "rgba(98,203,49,0.7)",
		                       pointColor: "rgba(98,203,49,1)",
		                       pointStrokeColor: "#fff",
		                       pointHighlightFill: "#fff",
		                       pointHighlightStroke: "rgba(26,179,148,1)",
		                       data: pre_tp2allscore_chart
		                   },
		                   {
		                       label: "Example dataset",
		                       fillColor: "rgba(220,220,220,0.5)",
		                       strokeColor: "rgba(220,220,220,1)",
		                       pointColor: "rgba(220,220,220,1)",		                       
		                       pointStrokeColor: "#fff",
		                       pointHighlightFill: "#fff",
		                       pointHighlightStroke: "rgba(220,220,220,1)",		                       
		                       data: pre_tp4allscore_chart
		                   }
		        ]
		    };

		    var lineOptions = {
		        scaleShowGridLines : true,
		        scaleGridLineColor : "rgba(0,0,0,.05)",
		        scaleGridLineWidth : 1,
		        bezierCurve : true,
		        bezierCurveTension : 0.4,
		        pointDot : true,
		        pointDotRadius : 4,
		        pointDotStrokeWidth : 1,
		        pointHitDetectionRadius : 20,
		        datasetStroke : true,
		        datasetStrokeWidth : 1,
		        datasetFill : true,
		        responsive: true
		    };
		   
		    var dataTable = "<canvas id='prodlcscorechart_modalprodlc' height='50'></canvas>";		    
		    $("#content_overallscorechart_box").append(dataTable);
		  
		    var ctx = document.getElementById("prodlcscorechart_modalprodlc").getContext("2d");
		    myNewChart = new Chart(ctx).Line(lineData, lineOptions);		    	
	}

	function RenderProdLcSppScore() {

		$("#content_overeallscore_box").html("");
		$("#maincharttitleprodlc").html("");
		$("#totalsurveys").html("");

		var dataTable = "";
		var dataTable2 = "";
		var maincharttitle = param_prodlc+" ";

		dataTable = dataTable + "<div class='col-lg-5 text-center'>";
		dataTable = dataTable + "<small class='stat-label'>Top Box 2</small>";
		dataTable = dataTable + "<h1 class='no-margins font-bold "+ ScorePassFail((tp2allscore * 100).toFixed(0))+ " overall_score'>" + (tp2allscore * 100).toFixed(0) + "</h1>";
		dataTable = dataTable + "<h4 >"	+ (pre_tp2allscore * 100).toFixed(0)+ " <i class='fa "+ ArrowUpDown((tp2allscore * 100).toFixed(0),(pre_tp2allscore * 100).toFixed(0), 1)+ " "+ ScorePassFail((tp2allscore * 100).toFixed(0), (pre_tp2allscore * 100).toFixed(0), 2) + "'></i></h4>";
		dataTable = dataTable + "<small class='stat-label'>Previous</small>";
		dataTable = dataTable + "</div>"
		dataTable = dataTable + "<div class='col-lg-5 text-center'>";
		dataTable = dataTable + "<small class='stat-label'>Top Box 4</small>";
		dataTable = dataTable + "<h1 class='no-margins font-bold " + ScorePassFail((tp4allscore * 100).toFixed(0)) + " overall_score'>" + (tp4allscore * 100).toFixed(0) + "</h1>";
		dataTable = dataTable + "<h4>" + (pre_tp4allscore * 100).toFixed(0) + " <i class='fa " + ArrowUpDown((tp4allscore * 100).toFixed(0), (pre_tp4allscore * 100).toFixed(0), 1)+ " "+ ArrowUpDown((tp4allscore * 100).toFixed(0), (pre_tp4allscore * 100).toFixed(0), 2) + "'></i></h4>";
		dataTable = dataTable + " <small class='stat-label'>Previous</small>";
		dataTable = dataTable + " </div>";

		dataTable2 = dataTable2 + "<h4> Total Surveys : "+totalsurveys+"</h4>";
		
		$("#content_overeallscore_box").append(dataTable);
		$("#maincharttitleprodlc").append(maincharttitle);
		$("#totalsurveys").append(dataTable2);


	}

}


function GetDetractSupportProdLcSppScore(param_view, param_freqno, param_yearno, param_prodlc){
	
	var tp2_supporter = "";
	var tp2_posambivalent = "";
	var tp2_negambivalent = "";
	var tp2_detractor = "";
	var tp2_total= "";
	
	
	GetDetractSupportSpp(param_view, param_freqno, param_yearno, param_prodlc);

	function GetDetractSupportSpp(param_view, param_freqno, param_yearno, param_prodlc) {

		var i = 0;

		$.ajax({
					type : "POST",
					url : "spp-admin/action-spp/sppscoredetractsupportprodlc",
					data : "{\"param_view\":" + '"' + SelectView(param_view,1)
							+ "\",\"param_freqno\":" + '"' + param_freqno
							+ "\",\"param_prodlc\":" + '"' + param_prodlc
							+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
					contentType : "application/x-www-form-urlencoded",
					dataType : "json",
					success : function(response) {

						var dataTable = "";
						var resultsArray = (typeof response) == 'string' ? eval('('
								+ response + ')')
								: response;

							tp2_supporter = (ZeroDivide(resultsArray[i].tp2_supporter_count,resultsArray[i].tp2_total)* 100);
							tp2_posambivalent = (ZeroDivide(resultsArray[i].tp2_posambivalent_count,resultsArray[i].tp2_total)* 100);
							tp2_negambivalent = (ZeroDivide(resultsArray[i].tp2_negambivalent_count,resultsArray[i].tp2_total)* 100);
							tp2_detractor = (ZeroDivide(resultsArray[i].tp2_detractors_count,resultsArray[i].tp2_total)* 100);



					},complete : function(e) {
	
						RenderDetractSupport();
						
					}

				});
	}
	
	
	function RenderDetractSupport(){
		$("#detractsupport_tab").html("");
		$("#satsurveybreakdown_box").html("");
		
		var dataTable = "";
		var dataTable2 = "";
		
		dataTable = dataTable +"<div class='row'>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Supporters: </span> <strong>"+ Math.round(tp2_supporter) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Positive: </span> <strong>"+ Math.round(tp2_posambivalent) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Negative: </span> <strong>"+ Math.round(tp2_negambivalent) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 '> <div class='contact-stat'><span>Detractors: </span> <strong>"+ Math.round(tp2_detractor) +"%</strong></div> </div>"
		dataTable = dataTable +"</div>"
		
		$("#detractsupport_tab").append(dataTable);
	
		 var doughnutData = [
		                     {			
		                    	 value: Math.round(tp2_supporter),
		                         color:"#62cb31",
		                         highlight: "#57b32c",
		                         label: "Supporters"
		                     },
		                     {
		                    	 value: Math.round(tp2_posambivalent),
		                         color: "#ffb606",
		                         highlight: "#FFC740",
		                         label: "Positive"
		                     },
		                     {
		                    	 value: Math.round(tp2_negambivalent),
		                         color: "#e67e22",
		                         highlight: "#E8A86F",
		                         label: "Negative"
		                     },
		                     {
		                    	 value: Math.round(tp2_detractor),
		                         color: "#c0392b",
		                         highlight: "#C77971",
		                         label: "Detractors"
		                     }
		                 ];

		                 var doughnutOptions = {
		                     segmentShowStroke: true,
		                     segmentStrokeColor: "#fff",
		                     segmentStrokeWidth: 2,
		                     percentageInnerCutout: 45,
		                     animationSteps: 100,
		                     animationEasing: "easeOutBounce",
		                     animateRotate: true,
		                     animateScale: false,
		                     responsive: true,
		                 };

		                 dataTable2 = dataTable2 + "<canvas id='satsurveybreakdown_modalprodlc' height='120'></canvas>" 
		                 $("#satsurveybreakdown_box").append(dataTable2);
		                 
		                 var ctx = document.getElementById("satsurveybreakdown_modalprodlc").getContext("2d");
		                 var myNewChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);		                 		
		              
	}
	
	
}


function GetFactorBucketsProdLcSppScore(param_view, param_freqno, param_yearno, param_prodlc){

	var q1_1 = "";
	var q1_2 = "";
	var q1_3 = "";
	var q1_4 = "";
	var q1_5 = "";
	var q1_6 = "";
	var q1_7 = "";
	var q1_8 = "";
	var q1_9 = "";
	var q1_10 = "";
	var q1_11 = "";
	var q1_12 = "";
	var q1_13 = "";
	var q2 = "";

	var knowledge_count  = "";
	var speed_count  = "";
	var ownership_count  = "";
	var communication_count  = "";
	
	var knowledge_total  = "";
	var speed_total  = "";
	var ownership_total  = "";
	var communication_total  = "";
	
	var knowledge_score  = "";
	var speed_score  = "";
	var ownership_score = "";
	var communication_score  = "";
	

	GetFactorBucketsSpp(param_view, param_freqno, param_yearno, param_prodlc);

	function GetFactorBucketsSpp(param_view, param_freqno, param_yearno, param_prodlc) {

		var i = 0;

		Math.average = function() {
			var cnt, tot, i;
			cnt = arguments.length;
			tot = i = 0;
			while (i < cnt) tot+= arguments[i++];
			return tot / cnt;
			}
		
		$.ajax({
					type : "POST",
					url : "spp-admin/action-spp/sppscorefactorbucketsprodlc",
					data : "{\"param_view\":" + '"' + SelectView(param_view,1)
							+ "\",\"param_freqno\":" + '"' + param_freqno
							+ "\",\"param_prodlc\":" + '"' + param_prodlc
							+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
					contentType : "application/x-www-form-urlencoded",
					dataType : "json",
					success : function(response) {

						
						var dataTable = "";
						var resultsArray = (typeof response) == 'string' ? eval('('
								+ response + ')')
								: response;

							knowledge_count	= (resultsArray[0].tp2_q1_1_count 
												+ resultsArray[0].tp2_q1_2_count
												+ resultsArray[0].tp2_q1_5_count
												+ resultsArray[0].tp2_q1_9_count
												+ resultsArray[0].tp2_q1_10_count
												+ resultsArray[0].tp2_q1_11_count
												+ resultsArray[0].tp2_q1_12_count
												+ resultsArray[0].tp2_q1_13_count);
												
							knowledge_total	= (resultsArray[0].tp2_q1_1_total 
												+ resultsArray[0].tp2_q1_2_total
												+ resultsArray[0].tp2_q1_5_total
												+ resultsArray[0].tp2_q1_9_total
												+ resultsArray[0].tp2_q1_10_total
												+ resultsArray[0].tp2_q1_11_total
												+ resultsArray[0].tp2_q1_12_total
												+ resultsArray[0].tp2_q1_13_total);
												
							speed_count	= (resultsArray[0].tp2_q1_12_count);												
							speed_total	= (resultsArray[0].tp2_q1_12_total);
							
							ownership_count	= (resultsArray[0].tp2_q1_6_count 
												+ resultsArray[0].tp2_q1_8_count
												+ resultsArray[0].tp2_q1_12_count);
							
							ownership_total	= (resultsArray[0].tp2_q1_6_total 
												+ resultsArray[0].tp2_q1_8_total
												+ resultsArray[0].tp2_q1_12_total);
							
							communication_count	= (resultsArray[0].tp2_q1_3_count 
												+ resultsArray[0].tp2_q1_4_count
												+ resultsArray[0].tp2_q1_7_count
												+ resultsArray[0].tp2_q1_8_count);
				
							communication_total	= (resultsArray[0].tp2_q1_3_total 
												+ resultsArray[0].tp2_q1_4_total
												+ resultsArray[0].tp2_q1_7_total
												+ resultsArray[0].tp2_q1_8_total);
					



					},complete : function(e) {

						RenderFactorBuckets();
						
					}

				});
	}
	
	
	function RenderFactorBuckets(){
		
				knowledge_score = (ZeroDivide(knowledge_count, knowledge_total)*100);
				speed_score = (ZeroDivide(speed_count, speed_total)*100).toFixed(0);
				ownership_score = (ZeroDivide(ownership_count, ownership_total)*100);
				communication_score = (ZeroDivide(communication_count, communication_total)*100);
				
		  
		$("#factorbuckets_box").html("");
		$("#factorbuckets_tab").html(""); 
		
		var dataTable = "";
		var dataTable2 = "";
		
		dataTable = dataTable +"<div class='row'>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Knowledge: </span> <strong>"+ Math.round(knowledge_score) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Speed: </span> <strong>"+ Math.round(speed_score) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Ownership: </span> <strong>"+ Math.round(ownership_score) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 '> <div class='contact-stat'><span>Comms: </span> <strong>"+ Math.round(communication_score) +"%</strong></div> </div>"
		dataTable = dataTable +"</div>"
		
		$("#factorbuckets_tab").append(dataTable);
	
		 var doughnutData = [
		                     {			
		                    	 value: Math.round(knowledge_score),
		                         color:"#62cb31",
		                         highlight: "#57b32c",
		                         label: "Knowledge"
		                     },
		                     {
		                    	 value: Math.round(speed_score),
		                         color: "#ffb606",
		                         highlight: "#FFC740",
		                         label: "Speed"
		                     },
		                     {
		                    	 value: Math.round(ownership_score),
		                         color: "#e67e22",
		                         highlight: "#E8A86F",
		                         label: "Ownership"
		                     },
		                     {
		                    	 value: Math.round(communication_score),
		                         color: "#c0392b",
		                         highlight: "#C77971",
		                         label: "Communication"
		                     }
		                 ];

		                 var doughnutOptions = {
		                     segmentShowStroke: true, 
		                     segmentStrokeColor: "#fff",
		                     segmentStrokeWidth: 2,
		                     percentageInnerCutout: 45,
		                     animationSteps: 100,
		                     animationEasing: "easeOutBounce",
		                     animateRotate: true,
		                     animateScale: false,
		                     responsive: true,
		                 };

		                 dataTable2 = dataTable2 + "<canvas id='factorbuckets_modalprodlc' height='120'></canvas>" 
		                 $("#factorbuckets_box").append(dataTable2);
		                 
		                 var ctx = document.getElementById("factorbuckets_modalprodlc").getContext("2d");
		                 var myNewChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);		                 		
		              
	}
	
	
}


function GetWgScore_TimeBucket(param_view, param_freqno, param_yearno, param_prodlc) {

	var tp2count_30below = [];
	var tp2count_30_60 = [];
	var tp2count_1_2hrs = [];
	var tp2count_2_4hrs = [];
	var tp2count_4_8hrs = [];
	var tp2count_8_24hrs = [];
	var tp2count_beyond24hrs = [];
	
	var tp2total_30below = [];
	var tp2total_30_60 = [];
	var tp2total_1_2hrs = [];
	var tp2total_2_4hrs = [];
	var tp2total_4_8hrs = [];
	var tp2total_8_24hrs = [];
	var tp2total_beyond24hrs = [];
	
	var case_owner_role = [];
	var rownum = "";

	GetSppTimeBucket_List(param_view, param_freqno, param_yearno, param_prodlc);

	function GetSppTimeBucket_List(param_view, param_freqno, param_yearno, param_prodlc) {

		var i = 0;

		$.ajax({
					type : "POST",
					url : "spp-admin/action-spp/sppscorewgtimebucket", 
					data : "{\"param_view\":" + '"' + SelectView(param_view,1)
							+ "\",\"param_freqno\":" + '"' + param_freqno
							+ "\",\"param_yearno\":" + '"' + param_yearno
							+ "\",\"param_prodlc\":" + '"' + param_prodlc + '"}',
					contentType : "application/x-www-form-urlencoded",
					dataType : "json",
					success : function(response) {

						var dataTable = "";
						var resultsArray = (typeof response) == 'string' ? eval('('
								+ response + ')')
								: response;

						for (var i = 0; i < resultsArray.length; i++) {
							rownum = resultsArray.length;
							case_owner_role[i] = resultsArray[i].case_owner_role;
							tp2count_30below[i] = resultsArray[i].tp2_30below_count;
							tp2count_30_60[i] = resultsArray[i].tp2_30_60_count;
							tp2count_1_2hrs[i] = resultsArray[i].tp2_1_2hrs_count;
							tp2count_2_4hrs[i] = resultsArray[i].tp2_2_4hrs_count;
							tp2count_4_8hrs[i] = resultsArray[i].tp2_4_8hrs_count;
							tp2count_8_24hrs[i] = resultsArray[i].tp2_8_24hrs_count;
							tp2count_beyond24hrs[i] = resultsArray[i].tp2_beyond24hrs_count;
							
							tp2total_30below[i] = resultsArray[i].tp2_30below_total;
							tp2total_30_60[i] = resultsArray[i].tp2_30_60_total;
							tp2total_1_2hrs[i] = resultsArray[i].tp2_1_2hrs_total;
							tp2total_2_4hrs[i] = resultsArray[i].tp2_2_4hrs_total;
							tp2total_4_8hrs[i] = resultsArray[i].tp2_4_8hrs_total;
							tp2total_8_24hrs[i] = resultsArray[i].tp2_8_24hrs_total;
							tp2total_beyond24hrs[i] = resultsArray[i].tp2_beyond24hrs_total;



						}

					},complete : function(e) {

						RenderSppScoreTimeBucket();
						
					}

				});
	}

	function RenderSppScoreTimeBucket() {
		
		$("#tp2timebucket").html("");

		var dataTable = "";

		dataTable = dataTable + "<thead><tr>"
		dataTable = dataTable + "<th>Functions</th>"
		dataTable = dataTable + "<th>30 mins below</th>"
		dataTable = dataTable + "<th>30 - 60 mins</th>"
		dataTable = dataTable + "<th>1 - 2 hrs</th>"
		dataTable = dataTable + "<th>2 - 4 hrs</th>"
		dataTable = dataTable + "<th>4 - 8 hrs</th>"
		dataTable = dataTable + "<th>8 - 24 hrs</th>"
		dataTable = dataTable + "<th>Beyond 24 hrs</th>"
		dataTable = dataTable + "</tr></thead>"
		dataTable = dataTable + "<tbody>"

		for (var i = 0; i < rownum; i++) {

			dataTable = dataTable + "<tr><td>" + case_owner_role[i] + "</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_30below[i] +" - " + (ZeroDivide(tp2count_30below[i], tp2total_30below[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_30_60[i] +" - " + (ZeroDivide(tp2count_30_60[i], tp2total_30_60[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_1_2hrs[i] +" - " + (ZeroDivide(tp2count_1_2hrs[i], tp2total_1_2hrs[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_2_4hrs[i] +" - " + (ZeroDivide(tp2count_2_4hrs[i], tp2total_2_4hrs[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_4_8hrs[i] +" - " + (ZeroDivide(tp2count_4_8hrs[i], tp2total_4_8hrs[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_8_24hrs[i] +" - " + (ZeroDivide(tp2count_8_24hrs[i], tp2total_8_24hrs[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_beyond24hrs[i] +" - " + (ZeroDivide(tp2count_beyond24hrs[i], tp2total_beyond24hrs[i]) * 100).toFixed(0) + "%</td></tr>"

		}

		dataTable = dataTable + "</tbody>"
		dataTable = dataTable + "</table>"

		$("#tp2timebucket").append(dataTable);

		$("#tp2timebucket").DataTable({
			ordering : false,
			paging : false,
			retrieve : true,
			info:     false
		});
		$(".dataTables_filter").hide();
	}

}


function GetWgSppScore_list(param_view, param_freqno, param_yearno, param_prodlc) {

	var case_owner_role = [];
	var tp2allscore = [];
	var tp4allscore = [];
	var pre_tp2allscore = [];
	var pre_tp4allscore = [];
	var rownum = "";

	GetSppScore_Cur(param_view, param_freqno, param_yearno, param_prodlc);

	function GetSppScore_Cur(param_view, param_freqno, param_yearno, param_prodlc) {

		var previous_freqno = param_freqno - 1;

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscorewglist",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno
					+ "\",\"param_prodlc\":" + '"' + param_prodlc
					+ '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

				for (var i = 0; i < resultsArray.length; i++) {

					rownum = resultsArray.length;
					case_owner_role[i] = resultsArray[i].case_owner_role;
					tp2allscore[i] = ZeroDivide(resultsArray[i].tp2_currentcm_count,resultsArray[i].tp2_currentcm_total);
					tp4allscore[i] = ZeroDivide(resultsArray[i].tp4_currentcm_count,resultsArray[i].tp4_currentcm_total);
				}

			},
			complete : function(e) {

				GetSppScore_Pre(param_view, previous_freqno,param_yearno, param_prodlc);

			}

		});
	}

	function GetSppScore_Pre(param_view, param_freqno, param_yearno, param_prodlc) {

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscorewglist",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno
					+ "\",\"param_prodlc\":" + '"' + param_prodlc
					+ '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;
				for (var i = 0; i < resultsArray.length; i++) {
					pre_tp2allscore[i] = ZeroDivide(resultsArray[i].tp2_currentcm_count,resultsArray[i].tp2_currentcm_total);
					pre_tp4allscore[i] = ZeroDivide(resultsArray[i].tp4_currentcm_count,resultsArray[i].tp4_currentcm_total);
				}

			},
			complete : function(e) {

				RenderSppScore();

			}

		});
	}

	function RenderSppScore() {

		$("#prodlc_list").html("");

		var dataTable = "";

		for (var i = 0; i < rownum; i++) {
        
			dataTable = dataTable + "<div class='list-item' onclick='RunScoreWg(\""+ case_owner_role[i] +"\")'>"
			dataTable = dataTable + "<div class='row'>"
			dataTable = dataTable + "<div class='col-xs-5 fnxlist_margin_ovrd'>"
			dataTable = dataTable + "<a href='#'><h5 class='no-margins font-bold text-color3'>"+ case_owner_role[i] + "</h5></a>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='col-xs-3 text-center m-l-m'>"
			dataTable = dataTable + "<small class='stat-label'>Top Box 2</small>" 
			dataTable = dataTable + "<h3 class='m-b-xxs " + ScorePassFail((tp2allscore[i] * 100).toFixed(0)) + "'>" + (tp2allscore[i] * 100).toFixed(0) + "</h3>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='col-xs-3 text-center pull-right'>" 
			dataTable = dataTable + "<small class='stat-label'>Top Box 4</small>"
			dataTable = dataTable + "<h3 class='m-b-xxs " + ScorePassFail((tp4allscore[i] * 100).toFixed(0)) + "'>" + (tp4allscore[i] * 100).toFixed(0) + "</h3>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='row'>"
			dataTable = dataTable + "<div class='col-xs-5'>"
			dataTable = dataTable + "<small class='stat-label no-margins'>Previous</small>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='col-xs-3 text-center m-l-m'>"
			dataTable = dataTable + "<small class='stat-label m-t-xxs text-center'>" + (pre_tp2allscore[i] * 100).toFixed(0) + "<i class='fa " + ArrowUpDown((tp2allscore[i] * 100).toFixed(0), (pre_tp2allscore[i] * 100).toFixed(0), 1) + " " + ArrowUpDown((tp2allscore[i] * 100).toFixed(0), (pre_tp2allscore[i] * 100).toFixed(0), 2) + "'></i></small>" 
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='col-xs-3 text-center pull-right'>" 
			dataTable = dataTable + "<small class='stat-label m-t-xxs text-center'>" + (pre_tp4allscore[i] * 100).toFixed(0) + " <i class='fa " + ArrowUpDown((tp4allscore[i] * 100).toFixed(0), (pre_tp4allscore[i] * 100).toFixed(0), 1)+ " " + ArrowUpDown((tp4allscore[i] * 100).toFixed(0), (pre_tp4allscore[i] * 100).toFixed(0), 2) + "'></i></small>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "</div>"

		}

		$("#prodlc_list").append(dataTable);
		
	}

}


// ///////////////////////////////ModalFunctionsTriggers Workgroup

function RunScoreWg(workgroup){
	param_global_workgroup = workgroup
	 $("#wgdetails_modal").modal('show')
	
}


// /////////////////Workgroup



function GetWgSppScore(param_view, param_freqno, param_yearno, param_workgroup) {
	 
	var tp2allscore = "";
	var tp4allscore = "";
	var pre_tp2allscore = "";
	var pre_tp4allscore = "";
	var pre_tp2allscore_chart = [];
	var pre_tp4allscore_chart = [];
	var pre_tp2allscore_chartlabel = [];
	
	GetWgSppScore_Cur(param_view, param_freqno, param_yearno, param_workgroup);

	function GetWgSppScore_Cur(param_view, param_freqno, param_yearno, param_workgroup) {

		var previous_freqno = param_freqno - 1;

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscorewg",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_workgroup\":" + '"' + param_workgroup
					+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

				tp2allscore = ZeroDivide(resultsArray[0].tp2_currentcm_count,resultsArray[0].tp2_currentcm_total);
				tp4allscore = ZeroDivide(resultsArray[0].tp4_currentcm_count,resultsArray[0].tp4_currentcm_total);

			},
			complete : function(e) {

				GetWgSppScore_Pre(param_view, previous_freqno,param_yearno, param_workgroup)
			}

		});
	}

	function GetWgSppScore_Pre(param_view, param_freqno, param_yearno, param_workgroup) {

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscorewg",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_workgroup\":" + '"' + param_workgroup
					+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

				pre_tp2allscore = ZeroDivide(resultsArray[0].tp2_currentcm_count,resultsArray[0].tp2_currentcm_total);
				pre_tp4allscore = ZeroDivide(resultsArray[0].tp4_currentcm_count,resultsArray[0].tp4_currentcm_total);

			},complete : function(e) {

				RenderWgSppScore()
				GetWgSppScore_Chart_Cur(param_view, param_freqno, param_yearno, param_workgroup)
			}

		});
	}
	
	function GetWgSppScore_Chart_Cur(param_view, param_freqno, param_yearno, param_workgroup) {

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscorewg",
			data : "{\"param_view\":" + '"' + SelectView(param_view,2)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno
					+ "\",\"param_workgroup\":" + '"' + param_workgroup
					+ '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

						for (var i = 0; i < resultsArray.length; i++) {
							
							pre_tp2allscore_chart.push((ZeroDivide(resultsArray[i].tp2_currentcm_count,resultsArray[i].tp2_currentcm_total)*100).toFixed(0));
							pre_tp4allscore_chart.push((ZeroDivide(resultsArray[i].tp4_currentcm_count,resultsArray[i].tp4_currentcm_total)*100).toFixed(0));
							pre_tp2allscore_chartlabel.push(resultsArray[i].freqno);
						}
						
			},
			complete : function(e) {
				 RenderChartJsData();
			}

		});
	}
	
	function RenderChartJsData (){
		
		$("#prodlcscorechart_box_modalwg").html("");
		var myNewChart = "";
		
		var lineData = {
		        labels: pre_tp2allscore_chartlabel,
		        datasets: [
		                   
		                   {
		                       label: "Example dataset",
		                       fillColor: "rgba(98,203,49,0.5)",		                       
		                       strokeColor: "rgba(98,203,49,0.7)",
		                       pointColor: "rgba(98,203,49,1)",
		                       pointStrokeColor: "#fff",
		                       pointHighlightFill: "#fff",
		                       pointHighlightStroke: "rgba(26,179,148,1)",
		                       data: pre_tp2allscore_chart
		                   },
		                   {
		                       label: "Example dataset",
		                       fillColor: "rgba(220,220,220,0.5)",
		                       strokeColor: "rgba(220,220,220,1)",
		                       pointColor: "rgba(220,220,220,1)",		                       
		                       pointStrokeColor: "#fff",
		                       pointHighlightFill: "#fff",
		                       pointHighlightStroke: "rgba(220,220,220,1)",		                       
		                       data: pre_tp4allscore_chart
		                   }
		        ]
		    };

		    var lineOptions = {
		        scaleShowGridLines : true,
		        scaleGridLineColor : "rgba(0,0,0,.05)",
		        scaleGridLineWidth : 1,
		        bezierCurve : true,
		        bezierCurveTension : 0.4,
		        pointDot : true,
		        pointDotRadius : 4,
		        pointDotStrokeWidth : 1,
		        pointHitDetectionRadius : 20,
		        datasetStroke : true,
		        datasetStrokeWidth : 1,
		        datasetFill : true,
		        responsive: true
		    };
		   
		    var dataTable = "<canvas id='prodlcscorechart_modalwg' height='50'></canvas>";		    
		    $("#prodlcscorechart_box_modalwg").append(dataTable);
		  
		    var ctx = document.getElementById("prodlcscorechart_modalwg").getContext("2d");
		    myNewChart = new Chart(ctx).Line(lineData, lineOptions);		    	
	}

	function RenderWgSppScore() {

		$("#prodlcscore_box_modalwg").html("");
		$("#maincharttitlewg").html("");

		var dataTable = "";
		var maincharttitle = param_workgroup+" ";
		var dataTable2 = "";
		
		dataTable = dataTable + "<div class='col-lg-5 text-center'>";
		dataTable = dataTable + "<small class='stat-label'>Top Box 2</small>";
		dataTable = dataTable + "<h1 class='no-margins font-bold "+ ScorePassFail((tp2allscore * 100).toFixed(0))+ " overall_score'>" + (tp2allscore * 100).toFixed(0) + "</h1>";
		dataTable = dataTable + "<h4 >"	+ (pre_tp2allscore * 100).toFixed(0)+ " <i class='fa "+ ArrowUpDown((tp2allscore * 100).toFixed(0),(pre_tp2allscore * 100).toFixed(0), 1)+ " "+ ScorePassFail((tp2allscore * 100).toFixed(0), (pre_tp2allscore * 100).toFixed(0), 2) + "'></i></h4>";
		dataTable = dataTable + "<small class='stat-label'>Previous</small>";
		dataTable = dataTable + "</div>"
		dataTable = dataTable + "<div class='col-lg-5 text-center'>";
		dataTable = dataTable + "<small class='stat-label'>Top Box 4</small>";
		dataTable = dataTable + "<h1 class='no-margins font-bold " + ScorePassFail((tp4allscore * 100).toFixed(0)) + " overall_score'>" + (tp4allscore * 100).toFixed(0) + "</h1>";
		dataTable = dataTable + "<h4>" + (pre_tp4allscore * 100).toFixed(0) + " <i class='fa " + ArrowUpDown((tp4allscore * 100).toFixed(0), (pre_tp4allscore * 100).toFixed(0), 1)+ " "+ ArrowUpDown((tp4allscore * 100).toFixed(0), (pre_tp4allscore * 100).toFixed(0), 2) + "'></i></h4>";
		dataTable = dataTable + " <small class='stat-label'>Previous</small>";
		dataTable = dataTable + " </div>";


		$("#prodlcscore_box_modalwg").append(dataTable);
		$("#maincharttitlewg").append(maincharttitle);


	}

}



function GetDetractSupportWgSppScore(param_view, param_freqno, param_yearno, param_workgroup){
	
	var tp2_supporter = "";
	var tp2_posambivalent = "";
	var tp2_negambivalent = "";
	var tp2_detractor = "";
	var tp2_total= "";
	
	
	GetDetractSupportSpp(param_view, param_freqno, param_yearno, param_workgroup);

	function GetDetractSupportSpp(param_view, param_freqno, param_yearno, param_workgroup) {

		var i = 0;

		$.ajax({
					type : "POST",
					url : "spp-admin/action-spp/sppscoredetractsupportwg",
					data : "{\"param_view\":" + '"' + SelectView(param_view,1)
							+ "\",\"param_freqno\":" + '"' + param_freqno
							+ "\",\"param_workgroup\":" + '"' + param_workgroup
							+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
					contentType : "application/x-www-form-urlencoded",
					dataType : "json",
					success : function(response) {

						var dataTable = "";
						var resultsArray = (typeof response) == 'string' ? eval('('
								+ response + ')')
								: response;

							tp2_supporter = (ZeroDivide(resultsArray[i].tp2_supporter_count,resultsArray[i].tp2_total)* 100);
							tp2_posambivalent = (ZeroDivide(resultsArray[i].tp2_posambivalent_count,resultsArray[i].tp2_total)* 100);
							tp2_negambivalent = (ZeroDivide(resultsArray[i].tp2_negambivalent_count,resultsArray[i].tp2_total)* 100);
							tp2_detractor = (ZeroDivide(resultsArray[i].tp2_detractors_count,resultsArray[i].tp2_total)* 100);



					},complete : function(e) {
	
						RenderDetractSupport();
						
					}

				});
	}
	
	
	function RenderDetractSupport(){
		$("#detractsupport_tab_modalwg").html("");
		$("#satsurveybreakdown_box_modalwg").html("");
		
		var dataTable = "";
		var dataTable2 = "";
		
		dataTable = dataTable +"<div class='row'>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Supporters: </span> <strong>"+ Math.round(tp2_supporter) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Positive: </span> <strong>"+ Math.round(tp2_posambivalent) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Negative: </span> <strong>"+ Math.round(tp2_negambivalent) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 '> <div class='contact-stat'><span>Detractors: </span> <strong>"+ Math.round(tp2_detractor) +"%</strong></div> </div>"
		dataTable = dataTable +"</div>"
		
		$("#detractsupport_tab_modalwg").append(dataTable);
	
		 var doughnutData = [
		                     {			
		                    	 value: Math.round(tp2_supporter),
		                         color:"#62cb31",
		                         highlight: "#57b32c",
		                         label: "Supporters"
		                     },
		                     {
		                    	 value: Math.round(tp2_posambivalent),
		                         color: "#ffb606",
		                         highlight: "#FFC740",
		                         label: "Positive"
		                     },
		                     {
		                    	 value: Math.round(tp2_negambivalent),
		                         color: "#e67e22",
		                         highlight: "#E8A86F",
		                         label: "Negative"
		                     },
		                     {
		                    	 value: Math.round(tp2_detractor),
		                         color: "#c0392b",
		                         highlight: "#C77971",
		                         label: "Detractors"
		                     }
		                 ];

		                 var doughnutOptions = {
		                     segmentShowStroke: true,
		                     segmentStrokeColor: "#fff",
		                     segmentStrokeWidth: 2,
		                     percentageInnerCutout: 45,
		                     animationSteps: 100,
		                     animationEasing: "easeOutBounce",
		                     animateRotate: true,
		                     animateScale: false,
		                     responsive: true,
		                 };

		                 dataTable2 = dataTable2 + "<canvas id='satsurveybreakdown_modalwg' height='120'></canvas>" 
		                 $("#satsurveybreakdown_box_modalwg").append(dataTable2);
		                 
		                 var ctx = document.getElementById("satsurveybreakdown_modalwg").getContext("2d");
		                 var myNewChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);		                 		
		              
	}
	
	
}


function GetFactorBucketsWgSppScore(param_view, param_freqno, param_yearno, param_workgroup){

	var q1_1 = "";
	var q1_2 = "";
	var q1_3 = "";
	var q1_4 = "";
	var q1_5 = "";
	var q1_6 = "";
	var q1_7 = "";
	var q1_8 = "";
	var q1_9 = "";
	var q1_10 = "";
	var q1_11 = "";
	var q1_12 = "";
	var q1_13 = "";
	var q2 = "";

	var knowledge_count  = "";
	var speed_count  = "";
	var ownership_count  = "";
	var communication_count  = "";
	
	var knowledge_total  = "";
	var speed_total  = "";
	var ownership_total  = "";
	var communication_total  = "";
	
	var knowledge_score  = "";
	var speed_score  = "";
	var ownership_score = "";
	var communication_score  = "";
	

	GetFactorBucketsSpp(param_view, param_freqno, param_yearno, param_workgroup);

	function GetFactorBucketsSpp(param_view, param_freqno, param_yearno, param_workgroup) {

		var i = 0;

		Math.average = function() {
			var cnt, tot, i;
			cnt = arguments.length;
			tot = i = 0;
			while (i < cnt) tot+= arguments[i++];
			return tot / cnt;
			}
		
		$.ajax({
					type : "POST",
					url : "spp-admin/action-spp/sppscorefactorbucketswg",
					data : "{\"param_view\":" + '"' + SelectView(param_view,1)
							+ "\",\"param_freqno\":" + '"' + param_freqno
							+ "\",\"param_workgroup\":" + '"' + param_workgroup
							+ "\",\"param_yearno\":" + '"' + param_yearno + '"}',
					contentType : "application/x-www-form-urlencoded",
					dataType : "json",
					success : function(response) {

						
						var dataTable = "";
						var resultsArray = (typeof response) == 'string' ? eval('('
								+ response + ')')
								: response;

							knowledge_count	= (resultsArray[0].tp2_q1_1_count 
												+ resultsArray[0].tp2_q1_2_count
												+ resultsArray[0].tp2_q1_5_count
												+ resultsArray[0].tp2_q1_9_count
												+ resultsArray[0].tp2_q1_10_count
												+ resultsArray[0].tp2_q1_11_count
												+ resultsArray[0].tp2_q1_12_count
												+ resultsArray[0].tp2_q1_13_count);
												
							knowledge_total	= (resultsArray[0].tp2_q1_1_total 
												+ resultsArray[0].tp2_q1_2_total
												+ resultsArray[0].tp2_q1_5_total
												+ resultsArray[0].tp2_q1_9_total
												+ resultsArray[0].tp2_q1_10_total
												+ resultsArray[0].tp2_q1_11_total
												+ resultsArray[0].tp2_q1_12_total
												+ resultsArray[0].tp2_q1_13_total);
												
							speed_count	= (resultsArray[0].tp2_q1_12_count);												
							speed_total	= (resultsArray[0].tp2_q1_12_total);
							
							ownership_count	= (resultsArray[0].tp2_q1_6_count 
												+ resultsArray[0].tp2_q1_8_count
												+ resultsArray[0].tp2_q1_12_count);
							
							ownership_total	= (resultsArray[0].tp2_q1_6_total 
												+ resultsArray[0].tp2_q1_8_total
												+ resultsArray[0].tp2_q1_12_total);
							
							communication_count	= (resultsArray[0].tp2_q1_3_count 
												+ resultsArray[0].tp2_q1_4_count
												+ resultsArray[0].tp2_q1_7_count
												+ resultsArray[0].tp2_q1_8_count);
				
							communication_total	= (resultsArray[0].tp2_q1_3_total 
												+ resultsArray[0].tp2_q1_4_total
												+ resultsArray[0].tp2_q1_7_total
												+ resultsArray[0].tp2_q1_8_total);
					



					},complete : function(e) {

						RenderFactorBuckets();
						
					}

				});
	}
	
	
	function RenderFactorBuckets(){
		
				knowledge_score = (ZeroDivide(knowledge_count, knowledge_total)*100);
				speed_score = (ZeroDivide(speed_count, speed_total)*100).toFixed(0);
				ownership_score = (ZeroDivide(ownership_count, ownership_total)*100);
				communication_score = (ZeroDivide(communication_count, communication_total)*100);
				
		
		$("#factorbuckets_box_modalwg").html("");
		$("#factorbuckets_tab_modalwg").html(""); 
		
		var dataTable = "";
		var dataTable2 = "";
		
		dataTable = dataTable +"<div class='row'>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Knowledge: </span> <strong>"+ Math.round(knowledge_score) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Speed: </span> <strong>"+ Math.round(speed_score) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 border-right'> <div class='contact-stat'><span>Ownership: </span> <strong>"+ Math.round(ownership_score) +"%</strong></div> </div>"
		dataTable = dataTable +"<div class='col-md-3 '> <div class='contact-stat'><span>Comms: </span> <strong>"+ Math.round(communication_score) +"%</strong></div> </div>"
		dataTable = dataTable +"</div>"
		
		$("#factorbuckets_tab_modalwg").append(dataTable);
	
		 var doughnutData = [
		                     {			
		                    	 value: Math.round(knowledge_score),
		                         color:"#62cb31",
		                         highlight: "#57b32c",
		                         label: "Knowledge"
		                     },
		                     {
		                    	 value: Math.round(speed_score),
		                         color: "#ffb606",
		                         highlight: "#FFC740",
		                         label: "Speed"
		                     },
		                     {
		                    	 value: Math.round(ownership_score),
		                         color: "#e67e22",
		                         highlight: "#E8A86F",
		                         label: "Ownership"
		                     },
		                     {
		                    	 value: Math.round(communication_score),
		                         color: "#c0392b",
		                         highlight: "#C77971",
		                         label: "Communication"
		                     }
		                 ];

		                 var doughnutOptions = {
		                     segmentShowStroke: true, 
		                     segmentStrokeColor: "#fff",
		                     segmentStrokeWidth: 2,
		                     percentageInnerCutout: 45,
		                     animationSteps: 100,
		                     animationEasing: "easeOutBounce",
		                     animateRotate: true,
		                     animateScale: false,
		                     responsive: true,
		                 };

		                 dataTable2 = dataTable2 + "<canvas id='factorbuckets_modalwg' height='120'></canvas>" 
		                 $("#factorbuckets_box_modalwg").append(dataTable2);
		                 
		                 var ctx = document.getElementById("factorbuckets_modalwg").getContext("2d");
		                 var myNewChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);		                 		
		              
	}
	
	
}

function GetAgScore_TimeBucket(param_view, param_freqno, param_yearno, param_workgroup) {

	var tp2count_30below = [];
	var tp2count_30_60 = [];
	var tp2count_1_2hrs = [];
	var tp2count_2_4hrs = [];
	var tp2count_4_8hrs = [];
	var tp2count_8_24hrs = [];
	var tp2count_beyond24hrs = [];
	
	var tp2total_30below = [];
	var tp2total_30_60 = [];
	var tp2total_1_2hrs = [];
	var tp2total_2_4hrs = [];
	var tp2total_4_8hrs = [];
	var tp2total_8_24hrs = [];
	var tp2total_beyond24hrs = [];
	
	var case_owner = [];
	var rownum = "";

	GetSppTimeBucket_List(param_view, param_freqno, param_yearno, param_workgroup);

	function GetSppTimeBucket_List(param_view, param_freqno, param_yearno, param_workgroup) {

		var i = 0;

		$.ajax({
					type : "POST",
					url : "spp-admin/action-spp/sppscoreagtimebucket", 
					data : "{\"param_view\":" + '"' + SelectView(param_view,1)
							+ "\",\"param_freqno\":" + '"' + param_freqno
							+ "\",\"param_yearno\":" + '"' + param_yearno
							+ "\",\"param_workgroup\":" + '"' + param_workgroup + '"}',
					contentType : "application/x-www-form-urlencoded",
					dataType : "json",
					success : function(response) {

						var dataTable = "";
						var resultsArray = (typeof response) == 'string' ? eval('('
								+ response + ')')
								: response;

						for (var i = 0; i < resultsArray.length; i++) {
							rownum = resultsArray.length;
							case_owner[i] = resultsArray[i].case_owner;
							tp2count_30below[i] = resultsArray[i].tp2_30below_count;
							tp2count_30_60[i] = resultsArray[i].tp2_30_60_count;
							tp2count_1_2hrs[i] = resultsArray[i].tp2_1_2hrs_count;
							tp2count_2_4hrs[i] = resultsArray[i].tp2_2_4hrs_count;
							tp2count_4_8hrs[i] = resultsArray[i].tp2_4_8hrs_count;
							tp2count_8_24hrs[i] = resultsArray[i].tp2_8_24hrs_count;
							tp2count_beyond24hrs[i] = resultsArray[i].tp2_beyond24hrs_count;
							
							tp2total_30below[i] = resultsArray[i].tp2_30below_total;
							tp2total_30_60[i] = resultsArray[i].tp2_30_60_total;
							tp2total_1_2hrs[i] = resultsArray[i].tp2_1_2hrs_total;
							tp2total_2_4hrs[i] = resultsArray[i].tp2_2_4hrs_total;
							tp2total_4_8hrs[i] = resultsArray[i].tp2_4_8hrs_total;
							tp2total_8_24hrs[i] = resultsArray[i].tp2_8_24hrs_total;
							tp2total_beyond24hrs[i] = resultsArray[i].tp2_beyond24hrs_total;



						}

					},complete : function(e) {

						RenderSppScoreTimeBucket();
						
					}

				});
	}

	function RenderSppScoreTimeBucket() {
		
		$("#tp2timebucket_modalwg").html("");

		var dataTable = "";

		dataTable = dataTable + "<thead><tr>"
		dataTable = dataTable + "<th>Functions</th>"
		dataTable = dataTable + "<th>30 mins below</th>"
		dataTable = dataTable + "<th>30 - 60 mins</th>"
		dataTable = dataTable + "<th>1 - 2 hrs</th>"
		dataTable = dataTable + "<th>2 - 4 hrs</th>"
		dataTable = dataTable + "<th>4 - 8 hrs</th>"
		dataTable = dataTable + "<th>8 - 24 hrs</th>"
		dataTable = dataTable + "<th>Beyond 24 hrs</th>"
		dataTable = dataTable + "</tr></thead>"
		dataTable = dataTable + "<tbody>"

		for (var i = 0; i < rownum; i++) {

			dataTable = dataTable + "<tr><td>" + case_owner[i] + "</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_30below[i] +" - " + (ZeroDivide(tp2count_30below[i], tp2total_30below[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_30_60[i] +" - " + (ZeroDivide(tp2count_30_60[i], tp2total_30_60[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_1_2hrs[i] +" - " + (ZeroDivide(tp2count_1_2hrs[i], tp2total_1_2hrs[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_2_4hrs[i] +" - " + (ZeroDivide(tp2count_2_4hrs[i], tp2total_2_4hrs[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_4_8hrs[i] +" - " + (ZeroDivide(tp2count_4_8hrs[i], tp2total_4_8hrs[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_8_24hrs[i] +" - " + (ZeroDivide(tp2count_8_24hrs[i], tp2total_8_24hrs[i]) * 100).toFixed(0) + "%</td>"
			dataTable = dataTable + "<td class='text-center'>"+ tp2total_beyond24hrs[i] +" - " + (ZeroDivide(tp2count_beyond24hrs[i], tp2total_beyond24hrs[i]) * 100).toFixed(0) + "%</td></tr>"

		}

		dataTable = dataTable + "</tbody>"
		dataTable = dataTable + "</table>"

		$("#tp2timebucket_modalwg").append(dataTable);

		$("#tp2timebucket_modalwg").DataTable({
			ordering : false,
			paging : false,
			retrieve : true,
			info:     false
		});
		$(".dataTables_filter").hide();
	}

}


function GetAgSppScore_list(param_view, param_freqno, param_yearno, param_workgroup) {

	var case_owner = [];
	var tp2allscore = [];
	var tp4allscore = [];
	var pre_tp2allscore = [];
	var pre_tp4allscore = [];
	var rownum = "";

	GetSppScore_Cur(param_view, param_freqno, param_yearno, param_workgroup);

	function GetSppScore_Cur(param_view, param_freqno, param_yearno, param_workgroup) {

		var previous_freqno = param_freqno - 1;

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscoreaglist",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno
					+ "\",\"param_workgroup\":" + '"' + param_workgroup
					+ '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;

				for (var i = 0; i < resultsArray.length; i++) {

					rownum = resultsArray.length;
					case_owner[i] = resultsArray[i].case_owner;
					tp2allscore[i] = ZeroDivide(resultsArray[i].tp2_currentcm_count,resultsArray[i].tp2_currentcm_total);
					tp4allscore[i] = ZeroDivide(resultsArray[i].tp4_currentcm_count,resultsArray[i].tp4_currentcm_total);
				}

			},
			complete : function(e) {

				GetSppScore_Pre(param_view, previous_freqno,param_yearno, param_workgroup);

			}

		});
	}

	function GetSppScore_Pre(param_view, param_freqno, param_yearno, param_workgroup) {

		var i = 0;
		$.ajax({
			type : "POST",
			url : "spp-admin/action-spp/sppscoreaglist",
			data : "{\"param_view\":" + '"' + SelectView(param_view,1)
					+ "\",\"param_freqno\":" + '"' + param_freqno
					+ "\",\"param_yearno\":" + '"' + param_yearno
					+ "\",\"param_workgroup\":" + '"' + param_workgroup
					+ '"}',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var dataTable = "";
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;
				for (var i = 0; i < resultsArray.length; i++) {
					pre_tp2allscore[i] = ZeroDivide(resultsArray[i].tp2_currentcm_count,resultsArray[i].tp2_currentcm_total);
					pre_tp4allscore[i] = ZeroDivide(resultsArray[i].tp4_currentcm_count,resultsArray[i].tp4_currentcm_total);
				}

			},
			complete : function(e) {

				RenderSppScore();

			}

		});
	}

	function RenderSppScore() {

		$("#agent_list_modal").html("");

		var dataTable = "";

		for (var i = 0; i < rownum; i++) {
        
			dataTable = dataTable + "<div class='list-item' onclick='RunScoreWg(\""+ case_owner[i] +"\")'>"
			dataTable = dataTable + "<div class='row'>"
			dataTable = dataTable + "<div class='col-xs-5 fnxlist_margin_ovrd'>"
			dataTable = dataTable + "<a href='#'><h4 class='no-margins font-bold text-color3'>"+ case_owner[i] + "</h4></a>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='col-xs-3 text-center m-l-m'>"
			dataTable = dataTable + "<small class='stat-label'>Top Box 2</small>" 
			dataTable = dataTable + "<h3 class='m-b-xxs " + ScorePassFail((tp2allscore[i] * 100).toFixed(0)) + "'>" + (tp2allscore[i] * 100).toFixed(0) + "</h3>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='col-xs-3 text-center pull-right'>" 
			dataTable = dataTable + "<small class='stat-label'>Top Box 4</small>"
			dataTable = dataTable + "<h3 class='m-b-xxs " + ScorePassFail((tp4allscore[i] * 100).toFixed(0)) + "'>" + (tp4allscore[i] * 100).toFixed(0) + "</h3>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='row'>"
			dataTable = dataTable + "<div class='col-xs-5'>"
			dataTable = dataTable + "<small class='stat-label no-margins'>Previous</small>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='col-xs-3 text-center m-l-m'>"
			dataTable = dataTable + "<small class='stat-label m-t-xxs text-center'>" + (pre_tp2allscore[i] * 100).toFixed(0) + "<i class='fa " + ArrowUpDown((tp2allscore[i] * 100).toFixed(0), (pre_tp2allscore[i] * 100).toFixed(0), 1) + " " + ArrowUpDown((tp2allscore[i] * 100).toFixed(0), (pre_tp2allscore[i] * 100).toFixed(0), 2) + "'></i></small>" 
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "<div class='col-xs-3 text-center pull-right'>" 
			dataTable = dataTable + "<small class='stat-label m-t-xxs text-center'>" + (pre_tp4allscore[i] * 100).toFixed(0) + " <i class='fa " + ArrowUpDown((tp4allscore[i] * 100).toFixed(0), (pre_tp4allscore[i] * 100).toFixed(0), 1)+ " " + ArrowUpDown((tp4allscore[i] * 100).toFixed(0), (pre_tp4allscore[i] * 100).toFixed(0), 2) + "'></i></small>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "</div>"
			dataTable = dataTable + "</div>"

		}

		$("#agent_list_modal").append(dataTable);
		
	}

}

function GetSppRawData(param_view, param_fxngroup, param_freqno, param_yearno) {
	$("#preloadcube").show(); 
	$("#rawdatabody").html("");
	
	var i = 0;
	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/sppscorerawdata",
		data : "{\"param_view\":" + '"' + SelectView(param_view,1)
				+ "\",\"param_fxngroup\":" + '"' + param_fxngroup
				+ "\",\"param_freqno\":" + '"' + param_freqno
				+ "\",\"param_yearno\":" + '"' + param_yearno
				+ '"}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
	
			var dataTable = "";
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
					
					dataTable = dataTable + "<table id='rawdatatab' class='table table-striped hover cell-border row-border' width='2500px'>"
					dataTable = dataTable + "<thead><tr>"
					dataTable = dataTable + "<th width='80px' style='text-align:center'>Serial Number</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 1</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 2</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 3</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 4</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 5</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 6</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 7</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 8</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 9</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 10</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 11</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 12</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q1 13</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q2</th>"
					dataTable = dataTable + "<th width='35px' style='text-align:center'>Q5 Level Involvement</th>"
					dataTable = dataTable + "<th style='text-align:center'>Case Owner Role</th>"
					dataTable = dataTable + "<th style='text-align:center'>Case Owner</th>"
					dataTable = dataTable + "<th style='text-align:center'>Function New Class</th>"
					dataTable = dataTable + "<th style='text-align:center'>Date Of Interview</th>"
					dataTable = dataTable + "<th style='text-align:center'>Time To 1St Call Back</th>"
					dataTable = dataTable + "<th style='text-align:center'>Closed In 30 Minutes</th>"
					dataTable = dataTable + "<th style='text-align:center'>Time To Close In Hrs Inc Oh</th>"
					dataTable = dataTable + "<th style='text-align:center'>Closure Time Buckets</th>"
					dataTable = dataTable + "</tr></thead>"
					dataTable = dataTable + "<tbody>"

					for (var i = 0; i <  resultsArray.length; i++) {

						dataTable = dataTable + "<tr>"
						dataTable = dataTable + "<td class='text-center' onclick='ViewVerbatim("+ NoUndefine(resultsArray[i].serial_number) +")'><a href='#'>"+NoUndefine(resultsArray[i].serial_number)+"</a></td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_1)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_2)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_3)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_4)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_5)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_6)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_7)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_8)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_9)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_10)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_11)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_12)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q1_13)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q2)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].q5_level_involvement)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].case_owner_role)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].case_owner)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].function_new_class)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].date_of_interview)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].time_to_1st_call_back)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].closed_in_30_minutes)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].time_to_close_in_hrs_inc_oh).toFixed(2)+"</td>"
						dataTable = dataTable + "<td class='text-center'>"+NoUndefine(resultsArray[i].closure_time_buckets)+"</td>"

						dataTable = dataTable + "</tr>"
					

					}

					dataTable = dataTable + "</tbody>"
					dataTable = dataTable + "</table>"

					$("#rawdatabody").append(dataTable);
					

		},complete : function(e) {
			$("#preloadcube").hide(); 
			GetUserAuditLog($("#uidlogged").val(), $("#user_role").text(), "View Raw Data", $("#user_name").text(),'');
			$('#rawdatatab').DataTable({
		        ordering : true,
				paging : true,
				retrieve : true,
				pageLength: 20,
				scrollX: true,
				"bDestroy" : true,
				destroy : true
			
			}); 

		}

	});
}

function ViewVerbatim(serialno){
	
	param_serialno = serialno;
	$("#rawdataverbatim").modal('show');	
}


function ViewVerbatimDetails(param_serialno) {
	
	$("#preload").show();
	$("#verbatimbox").html("");	
	var i = 0;
	$.ajax({
		type : "POST",
		url : "spp-admin/action-spp/sppscoreviewverbatim",
		data : "{\"param_serialno\":" + '"' + param_serialno
				+ '"}',
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
	
			var dataTable = "";
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

					dataTable = dataTable + "<div class='panel-heading'>"
					dataTable = dataTable + "<div class='media clearfix'>"
					dataTable = dataTable + "<div class='media-body'>"
					dataTable = dataTable + "<small>Serial Number: <span class='font-bold'><h2>"+ NoUndefine(resultsArray[i].serial_number) +"</h2></span> Case Owner: <span class='font-bold'>"+ NoUndefine(resultsArray[i].case_owner) +"</span> Overall Quality Score : <span class='font-bold'>"+ NoUndefine(resultsArray[i].q2) +"</span> </small>"
					dataTable = dataTable + "<br>"
					dataTable = dataTable + "<small class='text-muted'>Case Owner Role : <span class='font-bold'>"+ NoUndefine(resultsArray[i].case_owner_role) +"</span> Closure Time Bucket : <span class='font-bold'>"+  NoUndefine(resultsArray[i].closure_time_buckets) +"</span></small>"
					dataTable = dataTable + "</div>"
					dataTable = dataTable + "</div>"
					dataTable = dataTable + "</div>"
					dataTable = dataTable + "<div class='panel-body'>"
					dataTable = dataTable + " <h4>Case Subject : "+ NoUndefine(resultsArray[i].case_subject) +"</h4>"
					dataTable = dataTable + " <br>"
					dataTable = dataTable + " <h4>Description :</h4>"
					dataTable = dataTable + "<p>" + NoUndefine(resultsArray[i].description) + "</p>"
					dataTable = dataTable + " <h4>Resolution Comments :</h4>"
					dataTable = dataTable + "<p>" + NoUndefine(resultsArray[i].resolution_comment) + "</p>"
					dataTable = dataTable + " <h4>Customer Overall Service Feedback</h4>"
					dataTable = dataTable + "<p>" + NoUndefine(resultsArray[i].q3) + "</p>"
					dataTable = dataTable + "</div>"
					dataTable = dataTable + "<div class='panel-footer'>"
					dataTable = dataTable + "<span class='pull-right'>"
					dataTable = dataTable + "</span>"
					dataTable = dataTable + "</div>"

					$("#verbatimbox").append(dataTable);
					

		},complete : function(e) {
			$("#preload").hide();
			GetUserAuditLog($("#uidlogged").val(), $("#user_role").text(), "verbatim details", $("#user_name").text(),'');
		}

	});
}

function GetHdRaw(){

	window.location.href = "spprawadmin?param_view="+ SelectView($('#filter_view_rawmodal').val(),1) +"&param_fxngroup=Risk&param_freqno="+ $('#freqno_rawmodal').val() +"&param_yearno=" + $("#yearno_rawmodal").val();
	GetUserAuditLog($("#uidlogged").val(), $("#user_role").text(), "raw data download", $("#user_name").text(),'');
}


