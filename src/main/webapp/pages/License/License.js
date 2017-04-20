Application.$controller("LicensePageController", ["$scope", "$timeout", function($scope, $timeout) {
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


    $scope.licenseDetailsFormSuccess = function($event, $operation, $data) {
        $timeout(function() {
            $scope.Widgets.licenseDetailsForm.isUpdateMode = false;
        });
    };


    $scope.licenseStatusFormSuccess = function($event, $operation, $data) {
        $timeout(function() {
            $scope.Widgets.licenseStatusForm.isUpdateMode = false;
        });
    };


    $scope.licenseStatusFormBeforeservicecall = function($event, $operation, $data) {
        //debugger;

        $scope.Variables.LSUC_ApprovalData.setInput({
            "licenseeFk": $data.licenseeFk,
            "newIsPrimary": $data.isPrimary,
            "newEffectiveFromDate": $data.effectiveFromDate,
            "newEffectiveToDate": $data.effectiveToDate,
            "newClassPracticeGroupFk": $data.classPracticeGroupFk,
            "status": "Updated",
            "licenseeclasspracticegroupPk": $data.pk
                // ,
                // "oldIsPrimary": "",
                // "oldEffectiveFromDate": "",
                // "oldEffectiveToDate": "",
                // "oldClassPracticeGroupFk": ""
        });
        $scope.Variables.LSUC_ApprovalData.insertRecord();

        return false;
    };


    $scope.insuranceFormSuccess = function($event, $operation, $data) {
        $timeout(function() {
            $scope.Widgets.insuranceForm.isUpdateMode = false;
        });
    };


    $scope.liveform7Beforeservicecall = function($event, $operation, $data) {
        $data['licenseepersonlanguagepurposes'] = [{
            languagePurposeFk: $data.languagepurpose,
            licenseeFk: $scope.Variables.LicenseeData.firstRecord.pk
        }]
    };

}]);


Application.$controller("licenseStatusFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.licenseStUpBtnClick = function($event, $isolateScope) {
            $scope.isUpdateMode = true;
        };

    }
]);

Application.$controller("licenseDetailsFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.licenseDetUpBtnClick = function($event, $isolateScope) {
            $scope.isUpdateMode = true;
        };

    }
]);

Application.$controller("languagedatatableController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.addNewRowAction = function($event) {
            $scope.Widgets.addLanguageForm.new();
        };

    }
]);





Application.$controller("liveform4Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("insuranceForm Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("licenseDetailsForm Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid2 Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);



Application.$controller("licenseeinsurancepolicyDialogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform5Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("addInsuranceFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("addPolicyFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("policyFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("licenseeinsuranceDialogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.addInsuranceFormBeforeservicecall = function($event, $operation, $data) {
            $data.licenseeinsurancepolicies = [$scope.Widgets.policyForm.dataoutput];
        };

    }
]);


Application.$controller("addLanguageFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);