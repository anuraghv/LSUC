Application.$controller("PersonHistoryPageController", ["$scope", "Utils", function($scope, Utils) {
    "use strict";
    var CHANGE_TYPE_STATUS = "status",
        CHANGE_TYPE_ADDRESS = "address",
        CHANGE_TYPE_PERSON_DETAILS = "person";

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


    $scope.LSUCPersonAudDataonSuccess = function(variable, data) {
        if (data.length == 0) {
            return;
        }
        // Preparing dataSet based on comparing Latest two Objects.
        diffData(data, CHANGE_TYPE_PERSON_DETAILS, "Person Details Changed", "wi wi-person fa-2x");
    };



    function diffData(data, type, displayLabel, iconType) {
        // Looping based througth data objects 
        for (var i = 0; i < data.length - 1; i++) {
            var original = data[i],
                latest = data[i + 1];
            var historyData = {
                "type": "edit",
                "entity": "status",
                "newPropertyValues": [],
                "oldPropertyValues": [],
                "changedby": "Gerald",
                "timestamp": "",
                "icon": ""
            };
            // Compare the two Objects and Filtering change Data.
            _.reduce(original, function(result, val, key) {
                var newobj = {
                        types: "",
                        value: ""
                    },
                    oldObj = {
                        types: "",
                        value: ""
                    };
                // Compare conditions if type is CHANGE_TYPE_PERSON_DETAILS .
                if ((type == CHANGE_TYPE_PERSON_DETAILS) && !_.isEqual(latest[key], val) && !_.includes(["usernameRev", "rev", "revtype", "revtstmp", "changedBy"], key)) {
                    historyData.type = displayLabel;
                    newobj.types = Utils.prettifyLabel(key) || "-";
                    newobj.value = latest[key] || "-";
                    historyData.newPropertyValues.push(newobj);
                    oldObj.types = Utils.prettifyLabel(key) || "-";
                    oldObj.value = val || "-";
                    historyData.oldPropertyValues.push(oldObj);
                    historyData.icon = iconType;
                    historyData.timestamp = latest.usernameRev.timestamp;
                    historyData.changedby = latest.usernameRev.username;
                    // Compare conditions if type is CHANGE_TYPE_STATUS .
                } else if ((type == (CHANGE_TYPE_STATUS)) && !_.includes(["usernameRev", "rev", "revtype", "revtstmp", "changedBy"], key)) {
                    historyData.type = displayLabel;
                    newobj.types = Utils.prettifyLabel(key) || "-";
                    newobj.value = latest[key] || "-";
                    if (key == "effectiveFrom") {
                        newobj.types = Utils.prettifyLabel(key) || "-";
                        newobj.value = moment(latest[key]).format('DD MMM YYYY') || "-";
                    }
                    if (key == "effectiveTo") {
                        newobj.types = Utils.prettifyLabel(key) || "-";
                        newobj.value = moment(latest[key]).format('DD MMM YYYY') || "-";
                    }
                    historyData.newPropertyValues.push(newobj);
                    oldObj.types = Utils.prettifyLabel(key) || "-";
                    oldObj.value = val || "-";
                    if (key == "effectiveFrom") {
                        oldObj.types = Utils.prettifyLabel(key) || "-";
                        oldObj.value = moment(latest[key]).format('DD MMM YYYY') || "-";
                    }
                    if (key == "effectiveTo") {
                        oldObj.types = Utils.prettifyLabel(key) || "-";
                        oldObj.value = moment(latest[key]).format('DD MMM YYYY') || "-";
                    }
                    historyData.oldPropertyValues.push(oldObj);
                    historyData.icon = iconType;
                    historyData.timestamp = latest.revtstmp;
                    historyData.changedby = latest.changedBy;
                    // Compare conditions if type is CHANGE_TYPE_ADDRESS .
                } else if (type == CHANGE_TYPE_ADDRESS && !_.includes(["usernameRev", "rev", "revtype", "revtstmp", "changedBy", "person", "countryFk", "geographicAreaFk", "personFk", "person", "pk", "addresstypeFk", "isDisplayedOnDirectory", "provinceFk"], key)) {
                    historyData.type = displayLabel;
                    historyData.timestamp = latest.usernameRev.timestamp;
                    historyData.changedby = latest.usernameRev.username;
                    newobj.types = Utils.prettifyLabel(key) || "-";
                    newobj.value = latest[key] || "-";
                    if (key == "addresstype") {
                        newobj.types = Utils.prettifyLabel(key) || "-";
                        newobj.value = latest[key].shortNameEnglish || "-";
                    }
                    if (key == "province") {
                        newobj.types = Utils.prettifyLabel(key) || "-";
                        newobj.value = latest[key].shortNameEnglish || "-";
                    }
                    if (key == "country") {
                        newobj.types = Utils.prettifyLabel(key) || "-";
                        newobj.value = latest[key].shortNameEnglish || "-";
                    }
                    if (key == "geographicarea") {
                        newobj.types = Utils.prettifyLabel(key) || "-";
                        newobj.value = latest[key].shortNameEnglish || "-";
                    }
                    historyData.newPropertyValues.push(newobj);
                    oldObj.types = Utils.prettifyLabel(key) || "-";
                    oldObj.value = val || "-";
                    if (key == "addresstype") {
                        oldObj.types = "Address Type" || "-";
                        oldObj.value = latest[key].shortNameEnglish || "-";
                    }
                    if (key == "province") {
                        oldObj.types = Utils.prettifyLabel(key) || "-";
                        oldObj.value = latest[key].shortNameEnglish || "-";
                    }
                    if (key == "country") {
                        oldObj.types = Utils.prettifyLabel(key) || "-";
                        oldObj.value = latest[key].shortNameEnglish || "-";
                    }
                    if (key == "geographicarea") {
                        oldObj.types = "Geographic Area" || "-";
                        oldObj.value = latest[key].shortNameEnglish || "-";
                    }
                    historyData.oldPropertyValues.push(oldObj);
                    historyData.icon = iconType;


                }
            }, {});
            $scope.Variables.personHistoryData.dataSet.push(historyData);
        }
    }



    $scope.LSUCPersonaddresDataonSuccess = function(variable, data) {
        if (data.length == 0) {
            return;
        }
        // Prepares dataSet based on comparing Old and New Objects.
        diffData(data, CHANGE_TYPE_ADDRESS, "Address Changed", "wi wi-location-on fa-2x");
    };


    $scope.LicenseeClassPracticegrouponSuccess = function(variable, data) {
        if (data.length == 0) {
            return;
        }

        $scope.Variables.personHistoryData.dataSet = [];
        // Prepares dataSet based on comparing Old and New Objects.
        diffData(data.content, CHANGE_TYPE_STATUS, "Licensee Status Changed", "wi wi-pencil fa-2x");
    };

}]);


Application.$controller("grid1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);