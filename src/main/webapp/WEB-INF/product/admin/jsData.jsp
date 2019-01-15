<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; utf-8" pageEncoding="utf-8" %>
$(function () {
//一天内消费阶段
var data = {
labels: [<c:forEach items="${TClabel}" var="label" varStatus="s">
    "${label}"<c:if test="${!s.last}">,</c:if>
</c:forEach>], <%----%>
datasets: [{
label: '# of Votes',
data: [<c:forEach items="${TCdata}" var="da" varStatus="s">
    ${da}<c:if test="${!s.last}">,</c:if>
</c:forEach>],
backgroundColor: [
'rgba(255, 99, 132, 0.2)',
'rgba(54, 162, 235, 0.2)',
'rgba(255, 206, 86, 0.2)',
'rgba(75, 192, 192, 0.2)',
'rgba(153, 102, 255, 0.2)',
'rgba(255, 159, 64, 0.2)'
],
borderColor: [
'rgba(255,99,132,1)',
'rgba(54, 162, 235, 1)',
'rgba(255, 206, 86, 1)',
'rgba(75, 192, 192, 1)',
'rgba(153, 102, 255, 1)',
'rgba(255, 159, 64, 1)'
],
borderWidth: 1
}]
};
var options = {
scales: {
yAxes: [{
ticks: {
beginAtZero: true
}
}]
},
legend: {
display: false
},
elements: {
point: {
radius: 0
}
}
};
if ($("#lineChart").length) {
var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
var lineChart = new Chart(lineChartCanvas, {
type: 'line',
data: data,
options: options
});
}

//消费次数/星期
var data = {
labels: ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"],
datasets: [{
label: '# of Votes',
data: [
<c:forEach items="${numList}" var="num" varStatus="flag">
    ${num} <c:if test="${!flag.last}">,</c:if>
</c:forEach>],
backgroundColor: [
'rgba(255, 99, 132, 0.2)',
'rgba(54, 162, 235, 0.2)',
'rgba(255, 206, 86, 0.2)',
'rgba(75, 192, 192, 0.2)',
'rgba(153, 102, 255, 0.2)',
'rgba(255, 159, 64, 0.2)'
],
borderColor: [
'rgba(255,99,132,1)',
'rgba(54, 162, 235, 1)',
'rgba(255, 206, 86, 1)',
'rgba(75, 192, 192, 1)',
'rgba(153, 102, 255, 1)',
'rgba(255, 159, 64, 1)'
],
borderWidth: 1
}]
};
var options = {
scales: {
yAxes: [{
ticks: {
beginAtZero: true
}
}]
},
legend: {
display: false
},
elements: {
point: {
radius: 0
}
}

};
// Get context with jQuery - using jQuery's .get() method.
if ($("#barChart").length) {
var barChartCanvas = $("#barChart").get(0).getContext("2d");
// This will get the first returned node in the jQuery collection.
var barChart = new Chart(barChartCanvas, {
type: 'bar',
data: data,
options: options
});
}
// 正常卡/冻结卡
var doughnutPieData = {
datasets: [{
data: [${n1},${n2}],
backgroundColor: [
'rgba(255, 99, 132, 0.5)',
'rgba(54, 162, 235, 0.5)',
'rgba(255, 206, 86, 0.5)',
'rgba(75, 192, 192, 0.5)',
'rgba(153, 102, 255, 0.5)',
'rgba(255, 159, 64, 0.5)'
],
borderColor: [
'rgba(255,99,132,1)',
'rgba(54, 162, 235, 1)',
'rgba(255, 206, 86, 1)',
'rgba(75, 192, 192, 1)',
'rgba(153, 102, 255, 1)',
'rgba(255, 159, 64, 1)'
],
}],
labels: [
'正常卡',
'冻结卡',
]
};
var doughnutPieOptions = {
responsive: true,
animation: {
animateScale: true,
animateRotate: true
}
};
if ($("#doughnutChart").length) {
var doughnutChartCanvas = $("#doughnutChart").get(0).getContext("2d");
var doughnutChart = new Chart(doughnutChartCanvas, {
type: 'doughnut',
data: doughnutPieData,
options: doughnutPieOptions
});
}
});