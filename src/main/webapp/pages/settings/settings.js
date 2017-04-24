Application.$controller("settingsPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };


    /*handle text size change*/
    $scope.textSizeSwitchChange = function($event, $isolateScope, newVal, oldVal) {
        $scope.Variables.userPreference.dataSet.textsize = newVal;
        WM.element('#wm-app-content').removeClass('text-style-' + oldVal).addClass('text-style-' + newVal);
    };

    /*handle contrast theme changes*/
    $scope.contrastSwitchChange = function($event, $isolateScope, newVal, oldVal) {
        $scope.Variables.userPreference.dataSet.contrast = newVal;
        //check the user requested theme and add or remove the theme
        if (newVal === 'Dark') {
            WM.element('head').append('<link id="dark-theme" rel="stylesheet" type="text/css" href="themes/neon/style.css">');
        } else {
            WM.element('#dark-theme').remove();
        }
    };

}]);