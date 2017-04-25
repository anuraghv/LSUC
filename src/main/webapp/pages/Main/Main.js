Application.$controller("MainPageController", ["$scope", function($scope) {
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





    $scope.approveBtnClick = function($event, $isolateScope, item, currentItemWidgets) {
        if (item.status == "Created") {
            $scope.Variables.approveNewRequest.update();
        } else if (item.status == "Updated") {
            $scope.Variables.approvedEditRequest.update();
        }
    };


    $scope.approvedEditRequestonSuccess = function(variable, data) {
        if (data.result >= 1) {
            $scope.Variables.updateStatus.setInput("status", "Approved");
            $scope.Variables.updateStatus.setInput("pk", variable.dataBinding.approvalPk);
            $scope.Variables.updateStatus.update();
        }
    };


    $scope.approveNewRequestonSuccess = function(variable, data) {
        if (data.result >= 1) {
            $scope.Variables.updateStatus.setInput("status", "Approved");
            $scope.Variables.updateStatus.setInput("pk", variable.dataBinding.primaryKey);
            $scope.Variables.updateStatus.update();
        }
    };


    $scope.rejectBtnClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.Variables.updateStatus.setInput("status", "Rejected");
        $scope.Variables.updateStatus.setInput("pk", item.pk);
        $scope.Variables.updateStatus.update();
    };


    $scope.LicenseePracticegroupAudonSuccess = function(variable, data) {
        LicenseePracticegroup(data, "Status changed for");
    };

    function LicenseePracticegroup(data, type) {
        _.forEach(data, function(obj) {
            var HistoryData = {
                "type": "",
                "username": "",
                "timeStamp": "",
                "PersonID": "",
                "ChangedBy": ""
            }
            HistoryData.type = type;
            HistoryData.username = obj.licensee.person.firstName + " " + obj.licensee.person.lastName;
            HistoryData.shortcutName = obj.licensee.person.lastName[0];
            HistoryData.PersonID = obj.licensee.person.pk;
            HistoryData.timeStamp = obj.usernameRev.timestamp;
            HistoryData.ChangedBy = obj.usernameRev.username;
            $scope.Variables.PersonHistoryData.dataSet.push(HistoryData);
        });
    }
    $scope.PersonaddressAudonSuccess = function(variable, data) {
        PersonAddress(data, "Address changed for");
    };

    function PersonAddress(data, type) {
        _.forEach(data, function(obj) {
            var HistoryData = {
                "type": "",
                "username": "",
                "timeStamp": "",
                "PersonID": "",
                "ChangedBy": ""
            }
            HistoryData.type = type;
            HistoryData.username = obj.person.firstName + " " + obj.person.lastName;
            HistoryData.shortcutName = obj.person.lastName[0];
            HistoryData.PersonID = obj.person.pk;
            HistoryData.timeStamp = obj.usernameRev.timestamp;
            HistoryData.ChangedBy = obj.usernameRev.username;
            $scope.Variables.PersonHistoryData.dataSet.push(HistoryData);
        });
    }

    $scope.PersonAudonSuccess = function(variable, data) {
        $scope.Variables.PersonHistoryData.dataSet = []
        PersonHistory(data, "Personal Details changed for");
    };

    function PersonHistory(data, type) {
        _.forEach(data, function(obj) {
            var HistoryData = {
                "type": "",
                "username": "",
                "timeStamp": "",
                "PersonID": "",
                "ChangedBy": ""
            }
            HistoryData.type = type;
            HistoryData.username = obj.firstName + " " + obj.lastName;
            HistoryData.PersonID = obj.pk;
            HistoryData.shortcutName = obj.lastName[0];
            HistoryData.timestamp = obj.usernameRev.timestamp;
            HistoryData.ChangedBy = obj.usernameRev.username;
            $scope.Variables.PersonHistoryData.dataSet.push(HistoryData);
        });
    }

}]);