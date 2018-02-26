$(document).ready(function () {
    $("div.open-state").css("maxHeight", "inherit");
    $("div.open-state").css("overflow", "auto");
    $("button.open-state").toggleClass("active");

    $(".main-content").on("click", ".generic-accordion", function () {
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.maxHeight) {
            panel.style.maxHeight = null;
        } else {
            panel.style.maxHeight = panel.scrollHeight + "px";
        }
    });

    $(".main-content").on("click", ".expand", function () {
        $("button.generic-accordion").addClass("active");
        $("div.accordion-panel").css("maxHeight", "inherit");
        $("a.button-type").removeClass("active");
        this.classList.add("active");
    });

    $(".main-content").on("click", ".collapse", function () {
        $("button.generic-accordion").removeClass("active");
        $("div.accordion-panel").css("maxHeight", "");
        $("a.button-type").removeClass("active");
        this.classList.add("active");
    });

});
