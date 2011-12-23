document.write('<scr'+'ipt type="text/javascript" src="js/prototype.js" ></scr'+'ipt>');
document.write('<scr'+'ipt type="text/javascript" src="js/livepipe.js" ></scr'+'ipt>');
document.write('<scr'+'ipt type="text/javascript" src="js/slider.js" ></scr'+'ipt>');
document.write('<scr'+'ipt type="text/javascript" src="js/controls.js" ></scr'+'ipt>');
document.write('<scr'+'ipt type="text/javascript" src="js/effects.js" ></scr'+'ipt>');
document.write('<scr'+'ipt type="text/javascript" src="js/scrollbar.js" ></scr'+'ipt>');
//Store all scrolls on this page
scrollList = []; 
count = 0;
//Work around variable to wait for some delay before re-draw of scrolls.
run=false;
DRAW_DELAY=100;

function create(sc, st) { 
var scrollbar = new
Control.ScrollBar(sc,st); 
scrollList[count++] = scrollbar;	
}
function reDrawScroll() {
	//Work around to wait it for sometime. otherwise, sometimes it doesn't draw correctly.
	if(!run) {
		run=true;
		setTimeout(reDrawScroll, DRAW_DELAY);
		return;
	}
	for (var c = 0; c < scrollList.length; c++) {
		scrollList[c].recalculateLayout();
	}
	run=false;
}