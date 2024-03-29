$(document).ready(function () {
    $(".panel").first().css("display", "block");
    $(".tab").first().addClass('active')

    $(".main-content").on("click", ".accordion", function () {
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.maxHeight) {
            panel.style.maxHeight = null;
        } else {
            panel.style.maxHeight = panel.scrollHeight + "px";
        }
    });

    $(".main-content").on("click", ".tab", function (event) {
        $(".tab").removeClass("active");
        this.classList.add('active');
        var tabIndex = $(".tab").index(this);
        $(".panel").css("display", "none");
        $(".panel").eq(tabIndex).css("display", "block");
    });

    var desktopWidth = $('#nonmobile-indicator').data('width');
    if ($('#nonmobile-indicator').is(':visible') && desktopWidth) {
        $(".main-content").css("width", desktopWidth + "%")
    }
});
