/**
 * 
 */
app.controller('ChatCtrl', function($scope,$rootScope,chatService,$http)
{
	$scope.messages=[{id:0,message:''}];
	$scope.message="";
	$scope.max=250;
	var base_url="http://localhost:8081/middleware_project/";
	$scope.addMessage=function()
	{
		chatService.send($rootScope.loggedInUser.firstname+":" +$scope.message);
		
		
			
		$scope.messages=$http.get(base_url + "/getmessage/");
		alert($scope.messages.message)
		$scope.message="";
		chatService.receive().then(function(message){$scope.messages.push(message);});
	};

	

});