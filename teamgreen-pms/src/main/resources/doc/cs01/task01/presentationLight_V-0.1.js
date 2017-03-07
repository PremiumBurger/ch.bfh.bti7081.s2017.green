// presentationLight V 0.1 by Tobias Joder
//----------------------------------------\\
// - Page set-up
//   - Include JQuery
//   - Wrap the Presentationpart in <div id="presentation">
//   - Each step in the presentation tag with <.. data-pp="n">  --> n = presentation order.
//   - Hit Start Presentation to begin
//
// - Navigation in presentation mode:
//   - Arrow left = one step backward
//   - Arrow right or mouseclick = one step forward
//   - Click "Stop Presentation" to quit Presentation
//
// - To-Do: 
//   - e.g. Style "Start-/ Stopbuttons"
//   - e.g. View Presentation in Modal
//   - IMPROVE Code
//   - ...

$(document).ready(function () {
    presentationCnt = -1;
    presentationActive = false;
    aNumbers = [];
    aNumberslength = 0;
    $('<button id="startPresentation" style="position:fixed; bottom: 0; left: 0">Start Presentation</button>').insertAfter($("#presentation")).show();
    $('<button id="stopPresentation" style="position:fixed; bottom: 0; left: 0">Stop Presentation</button>').insertAfter($("#presentation")).hide();
    document.getElementById("startPresentation").onclick = startPresentation;
    document.getElementById("stopPresentation").onclick = stopPresentation;
    // Mouse forward Navigation
    $(document).click(function () {
        if (presentationActive) {
            if (presentationCnt < aNumberslength) {
                presentationCnt++;
                showHide(aNumbers);
            }
        }
    });
    // Key forward/backward - Navigation
    $(document).keydown(function (e) {
        if (presentationActive) {
            switch (e.which) {
                case 37:
                    if (presentationCnt >= 0) {
                        showHide(aNumbers);
                        presentationCnt--;
                    }
                    break;
                case 39:
                    if (presentationCnt < (aNumberslength - 1)) {
                        presentationCnt++;
                        showHide(aNumbers);
                    }
                    break;
                default:
                    return;
            }
        }
        ;
        e.preventDefault();
    });
});
stopPresentation = function (e) {
    presentationActive = false;
    $("[data-pp]").css('display', 'block');
    $("#startPresentation").show();
    $("#stopPresentation").hide();
    e.stopPropagation();
};
startPresentation = function (e) {
    $("#startPresentation").hide();
    $("#stopPresentation").show();
    var tmp = $("[data-pp]");
    var aNumbersTemp = [];
    for (let i = 0; i < tmp.length; i++) {
        aNumbersTemp.push(tmp.get(i).getAttribute("data-pp"));
    }
    aNumbers = aNumbersTemp;
    aNumberslength = aNumbers.length;
    aNumbers.sort(function (a, b) {
        return ((a < b) ? -1 : ((a > b) ? 1 : 0));
    });
    presentationCnt = -1;
    presentationActive = true;
    $("[data-pp]").css('display', 'none');
    e.stopPropagation();
};
showHide = function (arr) {
    $("[data-pp=" + arr[presentationCnt] + "]").toggle();
    $('html,body').animate({scrollTop: $("[data-pp=" + arr[presentationCnt] + "]").offset().top}, 'slow');
};