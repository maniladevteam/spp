<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>Service Pulse Portal</title>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!--<link rel="shortcut icon" type="image/ico" href="favicon.ico" />-->

    <!-- Vendor styles -->
    <link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.css" />
    <link rel="stylesheet" href="vendor/metisMenu/dist/metisMenu.css" />
    <link rel="stylesheet" href="vendor/animate.css/animate.css" />
    <link rel="stylesheet" href="vendor/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="vendor/datatables.net-bs/css/dataTables.bootstrap.min.css" />

    <!-- App styles -->
    <link rel="stylesheet" href="fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css" />
    <link rel="stylesheet" href="fonts/pe-icon-7-stroke/css/helper.css" />
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/style_custom.css">
    <link rel="stylesheet" href="styles/bootstrap-tour.min.css">

</head>

<body class="fixed-navbar fixed-sidebar">
<div id="preload"></div>
<!-- Simple splash screen-->
<div class="splash" id="splashscreen"> <div class="color-line"></div><div class="splash-title"><h1>Service Pulse Portal</h1><p>Loading Application Resources </p><div class="spinner"> <div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div> </div> </div>
<input type="hidden" id="uidlogged" disabled="disabled" value="${pageContext.request.remoteUser}"/> 
<!-- Header -->
<div id="header">
    <div class="color-line">
    </div>
    <div id="logo" class="light-version">
        <span>
           Service Pulse Portal
        </span>
    </div>
    <nav role="navigation">
        <div class="header-link hide-menu"><i class="fa fa-bars"></i></div>
        <div class="small-logo">
            <span class="text-primary">HOMER APP</span>
        </div>

        <div class="pull-right m-t-sm m-r-md ">
	        <a href="logout">
	            <i class="pe-7s-upload pe-rotate-90 logout_upperright"></i>
	        </a>
        </div>
        
        <div class="mobile-menu">
            <button type="button" class="navbar-toggle mobile-menu-toggle" data-toggle="collapse" data-target="#mobile-collapse">
                <i class="fa fa-chevron-down"></i>
            </button>
            <div class="collapse mobile-navbar" id="mobile-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a class="" href="login.html">Login</a>
                    </li>
                    <li>
                        <a class="" href="logout">Logout</a>
                    </li>
                    <li>
                        <a class="" href="profile.html">Profile</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="navbar-right">
            <ul class="nav navbar-nav no-borders">
                <!--<li class="dropdown">
                    <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                        <i class="pe-7s-speaker"></i>
                    </a>
                    <ul class="dropdown-menu hdropdown notification animated flipInX">
                        <li>
                            <a>
                                <span class="label label-success">NEW</span> It is a long established.
                            </a>
                        </li>
                        <li>
                            <a>
                                <span class="label label-warning">WAR</span> There are many variations.
                            </a>
                        </li>
                        <li>
                            <a>
                                <span class="label label-danger">ERR</span> Contrary to popular belief.
                            </a>
                        </li>
                        <li class="summary"><a href="#">See all notifications</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                        <i class="pe-7s-keypad"></i>
                    </a>

                    <div class="dropdown-menu hdropdown bigmenu animated flipInX">
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <a href="projects.html">
                                        <i class="pe pe-7s-portfolio text-info"></i>
                                        <h5>Projects</h5>
                                    </a>
                                </td>
                                <td>
                                    <a href="mailbox.html">
                                        <i class="pe pe-7s-mail text-warning"></i>
                                        <h5>Email</h5>
                                    </a>
                                </td>
                                <td>
                                    <a href="contacts.html">
                                        <i class="pe pe-7s-users text-success"></i>
                                        <h5>Contacts</h5>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="forum.html">
                                        <i class="pe pe-7s-comment text-info"></i>
                                        <h5>Forum</h5>
                                    </a>
                                </td>
                                <td>
                                    <a href="analytics.html">
                                        <i class="pe pe-7s-graph1 text-danger"></i>
                                        <h5>Analytics</h5>
                                    </a>
                                </td>
                                <td>
                                    <a href="file_manager.html">
                                        <i class="pe pe-7s-box1 text-success"></i>
                                        <h5>Files</h5>
                                    </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle label-menu-corner" href="#" data-toggle="dropdown">
                        <i class="pe-7s-mail"></i>
                        <span class="label label-success">4</span>
                    </a>
                    <ul class="dropdown-menu hdropdown animated flipInX">
                        <div class="title">
                            You have 4 new messages
                        </div>
                        <li>
                            <a>
                                It is a long established.
                            </a>
                        </li>
                        <li>
                            <a>
                                There are many variations.
                            </a>
                        </li>
                        <li>
                            <a>
                                Lorem Ipsum is simply dummy.
                            </a>
                        </li>
                        <li>
                            <a>
                                Contrary to popular belief.
                            </a>
                        </li>
                        <li class="summary"><a href="#">See All Messages</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" id="sidebar" class="right-sidebar-toggle">
                        <i class="pe-7s-upload pe-7s-news-paper"></i>
                    </a>
                </li>-->

            </ul>
        </div>
    </nav>
</div>

<!-- Navigation -->
<aside id="menu">
    <div id="navigation">
        <div class="profile-picture" id="userprofile">
            <a href="index.html">
                <img src="images/profile.jpg" class="img-circle m-b" alt="logo">
            </a>

            <div class="stats-label text-color">
                <span class="font-extra-bold font-uppercase" id="user_name">Jaypee Martinez</span>

                <div class="dropdown">
                    <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                        <small class="text-muted"><span id="user_role"></span><b class="caret"></b></small>
                    </a>
                    <ul class="dropdown-menu animated flipInX m-t-xs">
                        <li><a href="">Profile</a></li>
                        <li><a href="">Links</a></li>
                        <li><a href="">Analytics</a></li>
                        <li class="divider"></li>
                        <li><a href="logout">Logout</a></li>
                    </ul>
                </div>
				<!-- <div id='scorecard'>					
					<div class="row">
						<div class='score'>
							<b>Level:</b> {level} <br/>
							<b>Status:</b> {status}<br/>
							<i>'{quote}'</i><br/>
							<b>Score:</b> {score} <br/>
							<b>Level score:</b> {levelscore}/{leveltotal} <br/>
							<b>Total progress:</b> {totalprogress}% <br/>
						</div>
						<progress max="100" value="{levelprogress}"></progress>
					</div>	
					</div> -->

                <!-- <div>
                    <h4 class="font-extra-bold m-b-xs"  id="gamefyscore"></h4>
                    <small class="text-muted">YTD Current Raw Score</small>
                </div> -->
            </div>
        </div>

        <ul class="nav" id="side-menu">
            <li class="active">
                <a href=""> <span class="nav-label">Dashboard</span></a>
            </li>
            <li >
                <a href="javascript:void(0)" id="starttour" > <span class="nav-label" >Take a Tour</span></a>  
            </li>
            <li >
                <a href="#" ><span class="nav-label" id="rawdatabut">Raw Data</span></a>
            </li>
            <li id="filters">
                <a href="#"><span class="nav-label">Views</span><span class="fa arrow"></span> </a>
                <ul class="nav nav-second-level">
                	
                	<li>
                		<label class='col-sm-2 control-label m-t'>View</label>
                		<div class='col-sm-10 '>
	                		<select class="form-control m-b" name="filter_view" id="filter_view">
				                <option value="1">Month</option>
				                <option value="2">Week</option>
				                <option value="3">Quarter</option>
				                <option value="4">Year</option>
				            </select>
			            </div>
			        </li>                	
			        <li>			        	
			        		<label class='col-sm-2 control-label'>Year</label>
			        		<div class='col-sm-10'>
			        			<select class='form-control m-b' name='yearno' id='yearno' ></select>
			        		</div>			        	   
			        </li>
			        <li id="filter_freq">
                			<label class='col-sm-2 control-label' id="freqno_label"></label>
                			<div class='col-sm-10'>
                				<select class='form-control m-b' name='freqno' id='freqno'></select>
                			</div>
			        </li>
                </ul>
            </li>
        </ul>
    </div>
</aside>

<!-- Main Wrapper -->
<div id="wrapper">

    <div class="content animate-panel">

        <div class="row">
            <div class="col-lg-9">
            	 <div class="row">
		                <div class="hpanel">                    
		                    <div class="panel-body" id="mainscorebox">
		                        <div class="row">
		                            <div class="col-md-3 text-center">                            	
				                        <div class="row">
					                        <div class="stats-title text-center m-l-md">
			                            		<h4>Content Overall Score</h4>
			                        		</div>
				                        </div>
										<div class="row m-t-sm m-l-md" id="content_overeallscore_box"></div>
										<div class="row">
					                        <div class="stats-title text-center m-l-md">
			                            		<span id="totalsurveys"></span>
			                        		</div>
				                        </div>                          	                                
		                            </div>
		                            <div class="col-md-9">
		                                <div class="text-center small">
		                                     <h3>Service Pulse Trend Chart</h3>
		                                </div>
		                                <div class="flot-chart" id="content_overallscorechart_box"  style="height: 160px">
		                                    
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="panel-footer" id="updatedate"></div>
		                </div>
                </div>
                <div class="row">
		               <div class="row">
		       		 		<div class="col-md-4">
				                <div class="hpanel stats" id="scorebreakdownscore">		                
				                    <div class="panel-body piechart_box">
				                        <div class="stats-title pull-left">
				                            <h4>Survey Score Breakdown</h4>
				                        </div>
				                        <div class="stats-icon pull-right">
				                            <i class="pe-7s-shuffle fa-4x"></i>
				                        </div>
				                        <div class="clearfix"></div>
				                        <div class="flot-chart">
				                            <div class="flot-chart-content" id="satsurveybreakdown_box">
				                            	
				                            </div>
				                        </div>
				                        <div class="m-t-xs">
				                        </div>
				                    </div>
				                    <div class="panel-footer contact-footer" id="detractsupport_tab">
					                
					            	</div>
				                </div>
				            </div>
				            <div class="col-md-4">
				                <div class="hpanel stats" id="factorbucketsscore">		                
				                    <div class="panel-body piechart_box">
				                        <div class="stats-title pull-left">
				                            <h4>Contributing Factor Buckets</h4>
				                        </div>
				                        <div class="stats-icon pull-right">
				                            <i class="pe-7s-news-paper fa-4x"></i>
				                        </div>
				                        <div class="clearfix"></div>
				                        <div class="flot-chart">
				                            <div class="flot-chart-content" id="factorbuckets_box">
				                            	
				                            </div>
				                        </div>
				                        <div class="m-t-xs">
				
				                        </div>
				                    </div>
				                    <div class="panel-footer contact-footer" id="factorbuckets_tab">
					                
					            	</div>
				                </div>
				            </div>
				            <div class="col-lg-4">
				                <div class="hpanel stats">
				                
				                    <div class="panel-body h-200">
				                        <div class="stats-title pull-left">
				                            <h3>Overall Score</h3>
				                        </div>
				                        <div class="stats-icon pull-right">
				                            <i class="pe-7s-keypad fa-4x"></i>
				                        </div>
				                        <div class="clearfix"></div>
				                        <div class="flot-chart">
				                            <div class="flot-chart-content" id="overallscorechart_box">
				                            	
				                            </div>                            
				                        </div>
				                        <div class="m-t-xxl">
				                           <div class="row m-t-xxl .p-b-n-lg" id="overeallscore_box">
				                   
				                            </div>
				                        </div>
				                    </div>
				                    <div class="panel-footer">
				                        This is standard panel footer
				                    </div>
				                </div>
				            </div>
       		 			</div>
       		 			<div class="row">
		       		 		<div class="col-md-12">
						        <div class="hpanel" id="timelinessbucketscore">
		
						            <div class="panel-body">
						                <div class="table-responsive">
							                <h4>Timeliness Buckets</h4>
						               		<table id='tp2timebucket' class="table table-striped dt_rowpaddinfg hover cell-border row-border"></table>
										</div>				
						            </div>
						            <div class="panel-footer">
						                
						            </div>
						        </div>
						    </div>
		       		 	</div>
                </div>
    
            </div>
            <div class="col-lg-3">
                <div class="hpanel" id="functionscore">
                    <div class="panel-body list">
                    	<div class="row">
	                    	<div class="pull-right m-b-lg m-r-md">
	                        </div>
                    	</div>
                    	<div class="row">
                    		<div class="panel-title m-l" id="prodlc_listtitle"><h3>Workgroup</h3></div>
                    	</div> 
                        <small class="fo">Service Pulse Score by Workgroup</small>
                        <div class="list-group" id="prodlc_list"></div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Right sidebar -->
    <div id="right-sidebar" class="animated fadeInRight">

        <div class="p-m">
            <button id="sidebar-close" class="right-sidebar-toggle sidebar-button btn btn-default m-b-md"><i class="pe pe-7s-close"></i>
            </button>
            <div>
                <span class="font-bold no-margins"> Analytics </span>
                <br>
                <small> Lorem Ipsum is simply dummy text of the printing simply all dummy text.</small>
            </div>
            <div class="row m-t-sm m-b-sm">
                <div class="col-lg-6">
                    <h3 class="no-margins font-extra-bold text-success">300,102</h3>

                    <div class="font-bold">98% <i class="fa fa-level-up text-success"></i></div>
                </div>
                <div class="col-lg-6">
                    <h3 class="no-margins font-extra-bold text-success">280,200</h3>

                    <div class="font-bold">98% <i class="fa fa-level-up text-success"></i></div>
                </div>
            </div>
            <div class="progress m-t-xs full progress-small">
                <div style="width: 25%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="25" role="progressbar"
                     class=" progress-bar progress-bar-success">
                    <span class="sr-only">35% Complete (success)</span>
                </div>
            </div>
        </div>
        <div class="p-m bg-light border-bottom border-top">
            <span class="font-bold no-margins"> Social talks </span>
            <br>
            <small> Lorem Ipsum is simply dummy text of the printing simply all dummy text.</small>
            <div class="m-t-md">
                <div class="social-talk">
                    <div class="media social-profile clearfix">
                        <a class="pull-left">
                            <img src="images/a1.jpg" alt="profile-picture">
                        </a>

                        <div class="media-body">
                            <span class="font-bold">John Novak</span>
                            <small class="text-muted">21.03.2015</small>
                            <div class="social-content small">
                                Injected humour, or randomised words which don't look even slightly believable.
                            </div>
                        </div>
                    </div>
                </div>
                <div class="social-talk">
                    <div class="media social-profile clearfix">
                        <a class="pull-left">
                            <img src="images/a3.jpg" alt="profile-picture">
                        </a>

                        <div class="media-body">
                            <span class="font-bold">Mark Smith</span>
                            <small class="text-muted">14.04.2015</small>
                            <div class="social-content">
                                Many desktop publishing packages and web page editors.
                            </div>
                        </div>
                    </div>
                </div>
                <div class="social-talk">
                    <div class="media social-profile clearfix">
                        <a class="pull-left">
                            <img src="images/a4.jpg" alt="profile-picture">
                        </a>

                        <div class="media-body">
                            <span class="font-bold">Marica Morgan</span>
                            <small class="text-muted">21.03.2015</small>

                            <div class="social-content">
                                There are many variations of passages of Lorem Ipsum available, but the majority have
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="p-m">
            <span class="font-bold no-margins"> Sales in last week </span>
            <div class="m-t-xs">
                <div class="row">
                    <div class="col-xs-6">
                        <small>Today</small>
                        <h4 class="m-t-xs">$170,20 <i class="fa fa-level-up text-success"></i></h4>
                    </div>
                    <div class="col-xs-6">
                        <small>Last week</small>
                        <h4 class="m-t-xs">$580,90 <i class="fa fa-level-up text-success"></i></h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <small>Today</small>
                        <h4 class="m-t-xs">$620,20 <i class="fa fa-level-up text-success"></i></h4>
                    </div>
                    <div class="col-xs-6">
                        <small>Last week</small>
                        <h4 class="m-t-xs">$140,70 <i class="fa fa-level-up text-success"></i></h4>
                    </div>
                </div>
            </div>
            <small> Lorem Ipsum is simply dummy text of the printing simply all dummy text.
                Many desktop publishing packages and web page editors.
            </small>
        </div>

    </div>

    <!-- Footer-->
    <footer class="footer">
        <span class="pull-right">
            Performance and Business Planning - Web Development Group
        </span>
        Thomson Reuters
    </footer>

</div>

<!-- Modals ProdLC-->

	<div class="modal fade" id="prodlcdetails_modal" tabindex="-1" role="dialog"  aria-hidden="true">
	    <div class="modal-dialog modal-lg verylargemodal">
	        <div class="modal-content">
	            <div class="color-line"></div>

	            <div class="modal-body">
	               <div class="content animate-panel">

				        <div class="row">
				            <div class="col-lg-12">
				                <div class="hpanel">                    
				                    <div class="panel-body">
				                        <div class="row">
				                            <div class="col-md-3 text-center">                            	
						                        <div class="row">
							                        <div class="stats-title text-center m-l-md">
					                            		<h4>   Overall Score</h4>
					                        		</div>
						                        </div>
												<div class="row m-t-sm m-l-md" id="prodlcscore_box_modalprodlc"></div>                       	                                
				                            </div>
				                            <div class="col-md-9">
				                                <div class="text-center small">
				                                     <h3><span id="maincharttitleprodlc"></span>Service Pulse Trend Chart</h3>
				                                </div>
				                                <div class="flot-chart" id="prodlcscorechart_box_modalprodlc"  style="height: 160px">
				                                    
				                                </div>
				                            </div>
				                        </div>
				                    </div>
				                    <div class="panel-footer">
				                    <span class="pull-right">
				                          You have two new messages from <a href="">Monica Bolt</a>
				                    </span>
				                        Last update: 21.05.2015
				                    </div>
				                </div>
				            </div>

				        </div>
				        <div class="row">
				        	<div class="col-lg-8">
				       		 	<div class="row">
				       		 		<div class="col-md-6">
						                <div class="hpanel stats">		                
						                    <div class="panel-body piechart_box">
						                        <div class="stats-title pull-left">
						                            <h4>Survey Score Breakdown</h4>
						                        </div>
						                        <div class="stats-icon pull-right">
						                            <i class="pe-7s-cash fa-4x"></i>
						                        </div>
						                        <div class="clearfix"></div>
						                        <div class="flot-chart">
						                            <div class="flot-chart-content" id="satsurveybreakdown_box_modalprodlc"><canvas id="satsurveybreakdown_modalprodlc" height="138" width="345" style="width: 345px; height: 138px;"></canvas></div>
						                        </div>
						                        <div class="m-t-xs">
						                        </div>
						                    </div>
						                    <div class="panel-footer contact-footer" id="detractsupport_tab_modalprodlc"><div class="row"><div class="col-md-3 border-right"> <div class="contact-stat"><span>Supporters: </span> <strong>73%</strong></div> </div><div class="col-md-3 border-right"> <div class="contact-stat"><span>Positive: </span> <strong>23%</strong></div> </div><div class="col-md-3 border-right"> <div class="contact-stat"><span>Negative: </span> <strong>4%</strong></div> </div><div class="col-md-3 "> <div class="contact-stat"><span>Detractors: </span> <strong>1%</strong></div> </div></div></div>
						                </div>
						            </div>
						            <div class="col-md-6">
						                <div class="hpanel stats">		                
						                    <div class="panel-body piechart_box">
						                        <div class="stats-title pull-left">
						                            <h4>Contributing Factor Buckets</h4>
						                        </div>
						                        <div class="stats-icon pull-right">
						                            <i class="pe-7s-cash fa-4x"></i>
						                        </div>
						                        <div class="clearfix"></div>
						                        <div class="flot-chart">
						                            <div class="flot-chart-content" id="factorbuckets_box_modalprodlc"><canvas id="factorbuckets" height="138" width="345" style="width: 345px; height: 138px;"></canvas></div>
						                        </div>
						                        <div class="m-t-xs">
						
						                        </div>
						                    </div>
						                    <div class="panel-footer contact-footer" id="factorbuckets_tab_modalprodlc"><div class="row"><div class="col-md-3 border-right"> <div class="contact-stat"><span>Knowledge: </span> <strong>75%</strong></div> </div><div class="col-md-3 border-right"> <div class="contact-stat"><span>Speed: </span> <strong>76%</strong></div> </div><div class="col-md-3 border-right"> <div class="contact-stat"><span>Ownership: </span> <strong>78%</strong></div> </div><div class="col-md-3 "> <div class="contact-stat"><span>Comms: </span> <strong>81%</strong></div> </div></div></div>
						                </div>
						            </div>
				       		 	</div>
				       		 	<div class="row">
				       		 		<div class="col-md-12">
								        <div class="hpanel" id="timelinessbucketscore">
				
								            <div class="panel-body">
								                <div class="table-responsive">
									                <h4>Timeliness Buckets</h4>
				               						<table id='tp2timebucket_modalprodlc' class="table table-striped dt_rowpaddinfg hover cell-border row-border"></table>
												</div>				
								            </div>

								        </div>
								    </div>
				       		 	</div>
				            </div>            
				            <div class="col-lg-4">
				                <div class="hpanel">
				                    
				                    <div class="panel-body list">
				                        <div class="panel-title" id="prodlc_listtitle"><h3>Workgroup</h3></div>
				                        <small class="fo">Service Pulse Score by Workgroups</small>
				                        <div class="list-group" id="workgroup_list_modal"></div>
				
				                    </div>
				                </div>
				            </div>
				        </div>
				
				    </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
	
	
	
	<!-- Modals Workgroup-->

	<div class="modal fade" id="wgdetails_modal" tabindex="-1" role="dialog"  aria-hidden="true">
	    <div class="modal-dialog modal-lg verylargemodal">
	        <div class="modal-content">
	            <div class="color-line"></div>

	            <div class="modal-body">
	               <div class="content animate-panel">

				        <div class="row">
				            <div class="col-lg-12">
				                <div class="hpanel">                    
				                    <div class="panel-body">
				                        <div class="row">
				                            <div class="col-md-3 text-center">                            	
						                        <div class="row">
							                        <div class="stats-title text-center m-l-md">
					                            		<h4>   Overall Score</h4>
					                        		</div>
						                        </div>
												<div class="row m-t-sm m-l-md" id="prodlcscore_box_modalwg"></div>                       	                                
				                            </div>
				                            <div class="col-md-9">
				                                <div class="text-center small">
				                                     <h3><span id="maincharttitlewg"></span>Service Pulse Trend Chart</h3>
				                                </div>
				                                <div class="flot-chart" id="prodlcscorechart_box_modalwg"  style="height: 160px">
				                                    
				                                </div>
				                            </div>
				                        </div>
				                    </div>
				                    <div class="panel-footer">
				                    <span class="pull-right">
				                          You have two new messages from <a href="">Monica Bolt</a>
				                    </span>
				                        Last update: 21.05.2015
				                    </div>
				                </div>
				            </div>

				        </div>
				        <div class="row">
				        	<div class="col-lg-8">
				       		 	<div class="row">
				       		 		<div class="col-md-6">
						                <div class="hpanel stats">		                
						                    <div class="panel-body piechart_box">
						                        <div class="stats-title pull-left">
						                            <h4>Survey Score Breakdown</h4>
						                        </div>
						                        <div class="stats-icon pull-right">
						                            <i class="pe-7s-cash fa-4x"></i>
						                        </div>
						                        <div class="clearfix"></div>
						                        <div class="flot-chart">
						                            <div class="flot-chart-content" id="satsurveybreakdown_box_modalwg"><canvas id="satsurveybreakdown_modalprodlc" height="138" width="345" style="width: 345px; height: 138px;"></canvas></div>
						                        </div>
						                        <div class="m-t-xs">
						                        </div>
						                    </div>
						                    <div class="panel-footer contact-footer" id="detractsupport_tab_modalwg"><div class="row"><div class="col-md-3 border-right"> <div class="contact-stat"><span>Supporters: </span> <strong>73%</strong></div> </div><div class="col-md-3 border-right"> <div class="contact-stat"><span>Positive: </span> <strong>23%</strong></div> </div><div class="col-md-3 border-right"> <div class="contact-stat"><span>Negative: </span> <strong>4%</strong></div> </div><div class="col-md-3 "> <div class="contact-stat"><span>Detractors: </span> <strong>1%</strong></div> </div></div></div>
						                </div>
						            </div>
						            <div class="col-md-6">
						                <div class="hpanel stats">		                
						                    <div class="panel-body piechart_box">
						                        <div class="stats-title pull-left">
						                            <h4>Contributing Factor Buckets</h4>
						                        </div>
						                        <div class="stats-icon pull-right">
						                            <i class="pe-7s-cash fa-4x"></i>
						                        </div>
						                        <div class="clearfix"></div>
						                        <div class="flot-chart">
						                            <div class="flot-chart-content" id="factorbuckets_box_modalprodlc"><canvas id="factorbuckets_modalwg" height="138" width="345" style="width: 345px; height: 138px;"></canvas></div>
						                        </div>
						                        <div class="m-t-xs">
						
						                        </div>
						                    </div>
						                    <div class="panel-footer contact-footer" id="factorbuckets_tab_modalprodlc"><div class="row"><div class="col-md-3 border-right"> <div class="contact-stat"><span>Knowledge: </span> <strong>75%</strong></div> </div><div class="col-md-3 border-right"> <div class="contact-stat"><span>Speed: </span> <strong>76%</strong></div> </div><div class="col-md-3 border-right"> <div class="contact-stat"><span>Ownership: </span> <strong>78%</strong></div> </div><div class="col-md-3 "> <div class="contact-stat"><span>Comms: </span> <strong>81%</strong></div> </div></div></div>
						                </div>
						            </div>
				       		 	</div>
				       		 	<div class="row">
				       		 		<div class="col-md-12">
								        <div class="hpanel">
				
								            <div class="panel-body">
								                <div class="table-responsive">
									                <h4>Timeliness Buckets</h4>
				               						<table id='tp2timebucket_modalwg' class="table table-striped dt_rowpaddinfg hover cell-border row-border"></table>
												</div>				
								            </div>

								        </div>
								    </div>
				       		 	</div>
				            </div>            
				            <div class="col-lg-4">
				                <div class="hpanel">
				                    
				                    <div class="panel-body list">
				                        <div class="panel-title" id="prodlc_listtitle"><h3>Agents</h3></div>
				                        <small class="fo">Service Pulse Score Agents</small>
				                        <div class="list-group" id="agent_list_modal"></div>
				
				                    </div>
				                </div>
				            </div>
				        </div>
				
				    </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>

	
<!--  RAW DATA VIEW -->

	<div class="modal fade" id="SppRawData" tabindex="-1" role="dialog"  aria-hidden="true">
		   <div class="col-md-12 preload" id="preloadcube"></div>	
           <div class="modal-dialog modal-lg superlargemodal">
               <div class="modal-content">
                   <div class="color-line"></div>
                   <div class="modal-header custom_modal_header">
						<div class="row">
							<div class="col-md-8">
								<div class="col-md-2">									
			                		<div class="m-t-md">
			                			<label class='col-sm-2 control-label'>View</label>
				                		<select class="form-control m-b" name="filter_view_rawmodal" id="filter_view_rawmodal">
							                <option value="1">Month</option>
							                <option value="2">Week</option>
							                <option value="3">Quarter</option>
							                <option value="4">Year</option>
							            </select>
						            </div>
								</div>
								<div class="col-md-2">
										<div class="m-t-md">
		                        			<label class='col-sm-2 control-label'>Year</label>
					                        <select class='form-control m-b' name='yearno_rawmodal' id='yearno_rawmodal' ></select>
					                    </div>
								</div>
								<div class="col-md-2">
									<div class="m-t-md">
										<label class='col-sm-2 control-label' id="freqno_label_rawmodal"></label>		                			
		                				<select class='form-control m-b' name='freqno_rawmodal' id='freqno_rawmodal'></select>
		                			</div>	
								</div>
								<div class="col-md-2">									
		                			<div class="m-t-xl">
		                				<div class="col-md-6">
		                					<button type="button" class="btn btn-primary " id="extractrawdatabut">Run</button>
		                				</div>
		                				<div class="col-md-6">
		                					<button type="button" class="btn w-xs btn-info m-l" id="downloadraw" >Download</button>
		                				</div>
		                				
		                			</div>	
								</div>
							</div>
						</div>                                    

                    </div>
                   <div class="modal-body spprawdatabody">
                   		<div id="rawdatabody"> 
                   			<table id="rawdatatab" class="table table-striped hover cell-border row-border" cellspacing="0" width="2500px"></table>
                   		</div>							
                   </div>
               </div>
           </div>
       </div>
       <div class="modal fade" id="rawdataverbatim" tabindex="-1" role="dialog"  aria-hidden="true">
             <div class="modal-dialog modal-lg">
                 <div class="modal-content">
                     <div class="color-line"></div>
                     <div class="modal-body">
                         	<div class="hpanel blog-box" id="verbatimbox"></div>
                     </div>
                 </div>
             </div>
         </div>
         
         <div class="modal fade" id="intromodal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
               <div class="modal-dialog modal-lg">
                   <div class="modal-content">
                       <div class="modal-body">
	                       <div class="panel-image">
					            <img class="img-responsive" src="images/banner.jpg" height="500" width="840" >
					        </div>
                          
                       </div>
                       <div class="modal-footer">
                           <span id="intromodalclose"></span>
                           <button type='button' class='btn btn-default' data-dismiss='modal' id='disableintro'>Disable Tour</button>
                           <button type="button" class="btn btn-primary" id="tourmodal">Take the Tour</button>
                       </div>
                   </div>
               </div>
           </div>

<!-- Vendor scripts -->
<script src="vendor/jquery/dist/jquery.min.js"></script>
<script src="vendor/jquery-ui/jquery-ui.min.js"></script>
<script src="vendor/slimScroll/jquery.slimscroll.min.js"></script>
<script src="vendor/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="vendor/jquery-flot/jquery.flot.js"></script>
<script src="vendor/jquery-flot/jquery.flot.resize.js"></script>
<script src="vendor/jquery-flot/jquery.flot.pie.js"></script>
<script src="vendor/flot.curvedlines/curvedLines.js"></script>
<script src="vendor/jquery.flot.spline/index.js"></script>
<script src="vendor/metisMenu/dist/metisMenu.min.js"></script>
<script src="vendor/iCheck/icheck.min.js"></script>
<script src="vendor/peity/jquery.peity.min.js"></script>
<script src="vendor/sparkline/index.js"></script>
<script src="vendor/chartjs/Chart.min.js"></script>


<!-- DataTables -->
<script src="vendor/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="vendor/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- DataTables buttons scripts -->
<script src="vendor/pdfmake/build/pdfmake.min.js"></script>
<script src="vendor/pdfmake/build/vfs_fonts.js"></script>
<script src="vendor/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="vendor/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="vendor/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="vendor/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>

<!-- App scripts -->
<script src="scripts/homer.js"></script>
<script src="modules/scoregen_risk.js"></script>
<!-- <script src="chartjs/src/charts.js"></script> -->

<!-- ScoreJs -->
<script src="js/score.js"></script>  

<!-- TOUR -->
<script src="js/bootstrap-tour.min.js"></script>  




</body>
</html>