(function($) {
  'use strict';
  $(function() {

    $('[data-toggle="expansionPanel"]').on('click', function() {
      $('#' + $(this).attr("target-panel")).toggleClass('expanded');
    });

    /* Dropdown */
    $('[data-toggle="dropdown"]').on('click', function() {
      var menuEl = document.querySelector('#' + $(this).attr("toggle-dropdown"));
      var menu = new mdc.menu.MDCSimpleMenu(menuEl);
      menu.open = !menu.open;
    });

    mdc.autoInit();

    /* Select menu */
    var MDCSelect = mdc.select.MDCSelect;
    if ($('#hero-js-select').length) {
      var heroSelect = document.getElementById('hero-js-select');
      var heroSelectComponent = new mdc.select.MDCSelect(heroSelect);
    }

    /* username field */
    if ($('#username-box').length) {
      var tfEl = document.getElementById('username-box');
      var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#username-box-wrapper').length) {
      var wrapper = document.getElementById('username-box-wrapper');
    }

    /* password field */
    if ($('#password-box').length) {
      var tfEl = document.getElementById('password-box');
      var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#password-box-wrapper').length) {
      var wrapper = document.getElementById('password-box-wrapper');
    }
  });
})(jQuery);