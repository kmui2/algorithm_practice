
/*
Closure example
*/

function stopwatch(){
var starttime = Date.now();

function delay(){
var elapsedtime = Date.now()-starttime;
alert("elapsed time:"+ elapsedtime);
}
return delay();
}

var timer = stopwatch();
for(var i=0;i<1000000;i++){
//blank loop for timer
var foo=Math.random()*1000;
}

stopwatch();