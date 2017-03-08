// the semi-colon before the function invocation is a safety
// net against concatenated scripts and/or other plugins
// that are not closed properly.
; (function ($, window, document, undefined) {
    // Create the defaults once 
    var pluginName = "presi",
        defaults = {
            slideSelector: 'pp'
        };

    // The actual plugin constructor
    function Plugin(element, options) {
        this.element = element;
        this.options = $.extend({}, defaults, options);
        this._defaults = defaults;
        this._name = pluginName;
        this.init();
    }

    Plugin.prototype = {
        init: function () {
            this.presentationCnt = -1;
            this.presentationActive = false;
            this.aNumbers = [];
            this.aNumberslength = 0;

            this.cacheElements();
            this.drawElements();
            this.bindEvents();
        },
        cacheElements: function () {
            this.$startButton = $('<button type="button" class="btn btn-default" style="position:fixed; bottom: 0; left: 0">Start Presentation</button>').show();
            this.$stopButton = $('<button type="button" class="btn btn-default" style="position:fixed; bottom: 0; left: 0">Stop Presentation</button>').hide();
            this.slides = $(this.element).find('[data-' + this.options.slideSelector + ']');
            this.$document = $(document);
        },
        drawElements: function () {
            $('body')
                .append(this.$startButton)
                .append(this.$stopButton);
        },
        bindEvents: function () {
            this.$startButton.on('click', $.proxy(this.startPresentation, this));
            this.$stopButton.on('click', $.proxy(this.stopPresentation, this));
            this.$document.on('click', $.proxy(this.onMouseNavigation, this));
            this.$document.on('keydown', $.proxy(this.onKeyNavigation, this));
        },
        onKeyNavigation: function (e) {
            if (this.presentationActive) {
                switch (e.which) {
                    case 37:
                        if (this.presentationCnt >= 0) {
                            this.showHide(this.aNumbers);
                            this.presentationCnt--;
                        }
                        break;
                    case 39:
                        if (this.presentationCnt < (this.aNumberslength - 1)) {
                            this.presentationCnt++;
                            this.showHide(this.aNumbers);
                        }
                        break;
                    default:
                        return;
                }
            };
        },
        onMouseNavigation: function () {
            if (this.presentationActive) {
                if (this.presentationCnt < this.aNumberslength) {
                    this.presentationCnt++;
                    this.showHide(this.aNumbers);
                }
            }
        },
        stopPresentation: function (e) {
            this.presentationActive = false;
            this.slides.css('display', 'block');
            this.$startButton.show();
            this.$stopButton.hide();
            e.stopPropagation();
        },
        startPresentation: function (e) {
            this.$startButton.hide();
            this.$stopButton.show();
            var aNumbersTemp = [];
            for (let i = 0; i < this.slides.length; i++) {
                var slide = this.slides.eq(i).data(this.options.slideSelector);
                aNumbersTemp.push(slide);
            }
            this.aNumbers = aNumbersTemp;
            this.aNumberslength = this.aNumbers.length;
            this.aNumbers.sort(function (a, b) {
                return ((a < b) ? -1 : ((a > b) ? 1 : 0));
            });
            this.presentationCnt = -1;
            this.presentationActive = true;
            this.slides.css('display', 'none');
            e.stopPropagation();
        },
        showHide: function (arr) {
            var self = this;
            $("[data-" + this.options.slideSelector + "=" + arr[this.presentationCnt] + "]").toggle(0, function() {
                $('html,body').animate({scrollTop: $("[data-" + self.options.slideSelector + "=" + arr[self.presentationCnt] + "]").offset().top}, 'slow');
            });
        }
    };

    // A really lightweight plugin wrapper around the constructor,
    // preventing against multiple instantiations
    $.fn[pluginName] = function (options) {
        return this.each(function () {
            if (!$.data(this, "plugin_" + pluginName)) {
                $.data(this, "plugin_" + pluginName,
                    new Plugin(this, options));
            }
        });
    };
})(jQuery, window, document);