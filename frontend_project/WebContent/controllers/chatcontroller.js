/**
 * 
 */
app.controller('ChatCtrl', function($scope,$rootScope,chatService,$http)
{
	$scope.messages;
	chatService.receive().then(function(message){$scope.messages=message.data;});
	$scope.message="";
	$scope.max=250;

	$scope.addMessage=function()
	{
		chatService.send($rootScope.loggedInUser.firstname+":" +$scope.message);
		$scope.message="";
		
	};

	

});