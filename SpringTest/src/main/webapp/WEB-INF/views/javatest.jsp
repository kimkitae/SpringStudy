<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {

		
		values1 = new Array();
		values2 = new Array();
		
		values1[0] = "1";
		values1[1] = "2";
		values1[2] = "3";
		
		values2[0] = 234;
		values2[1] = 345;
		values2[2] = 789;
		
// 		var data = google.visualization.arrayToDataTable([ 
// ['담보','표준','금액'], 
// ['자료1',  10000,5000], 
// ['자료2', 10000,1000], 
// ['자료3',  10000,7000], 
// ['자료4', 10000,0]  ]); 
var count = values1.length;
var data = new google.visualization.DataTable();
data.addColumn('string', 'Round');
data.addColumn('number', 'Average');
data.addRows(count);
for(i = 0; i <= count-1; i++) {

  

data.setCell(i, 0, values1[i]);
data.setCell(i, 1, values2[i]);
// data.setCell(1, 0, "2");
// data.setCell(1, 1, 4536);

}


		
		
		
		var options = {
			title : 'Current '
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
	<div id="chart_div" style="width: 900px; height: 500px;"></div>
</body>
</html>