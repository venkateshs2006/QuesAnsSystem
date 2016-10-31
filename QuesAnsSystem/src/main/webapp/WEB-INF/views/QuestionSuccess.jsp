<link rel="stylesheet" href="resources/jquery-ui.css">
<script type="text/javascript" src="resources/jquery.min.js"></script>
<script src="resources/jquery-ui.js"></script>
<script type="text/javascript">
    $(function() {   
             
        $( "#tabs" ).tabs();
    });
</script>
<div id="tabs">
<ul>
    <li><a href="#tabs-1">QuesAnsPortal</a></li>
    <li><a href="#tabs-2">WikiPedia</a></li>
    <li><a href="#tabs-3">Google</a></li>
  </ul>
<div id="tabs-1">Your Question : ${ques} 
<p>Answer : ${answer}</p></div>
<div id="tabs-2">${wiki}</div>
<div id="tabs-3">${google}</div>
</div>