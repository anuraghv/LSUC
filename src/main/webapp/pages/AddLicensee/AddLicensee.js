Application.$controller("AddLicenseePageController", ["$scope", function($scope) {
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


    $scope.personLiveFormBeforeservicecall = function($event, $operation, $data) {
        debugger;
        $data.addresses = [$scope.Widgets.addresses.dataoutput];
        $data.licensees = [$scope.Widgets.licensees.dataoutput];
        $data.personroles = [$scope.Widgets.personroles.dataoutput];
        //$data.licensees[0].licenseeclasspracticegroups = [$scope.Widgets.licenseeclasprctcegrpLiveForm.dataoutput];
    };


    $scope.personLiveFormSuccess = function($event, $operation, $data) {
        debugger;
        $scope.Variables.LSUC_ApprovalData.setInput({
            "licenseeFk": $data.licensees[0].pk,
            "newIsPrimary": "N",
            "newEffectiveFromDate": $scope.Widgets.licenseeclasprctcegrpLiveForm.dataoutput.effectiveFromDate,
            "newEffectiveToDate": $scope.Widgets.licenseeclasprctcegrpLiveForm.dataoutput.effectiveToDate,
            "newClassPracticeGroupFk": $scope.Widgets.licenseeclasprctcegrpLiveForm.dataoutput.classpraticegroup.pk,
            "status": "Created"
        });
        $scope.Variables.LSUC_ApprovalData.insertRecord();
    };

}]);


Application.$controller("personLiveFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("addressesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("licenseesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("licenseeclasprctcegrpLiveFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("personrolesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);