<?php

	$data1 = array( 'a', 'b', 'c' );
	$data2 = array( 'name' => 'God', 'age' => -1 );
	$option = 1; 
	header('Content-type: application/json');

 

	$arr = array(
    array(
	        "name" => "Indian Food Truck",
	        "votes" => "44",
	        "menus" => array(
	        	0 => array(
	        			"id" => 1,
	        			"item" => "Red Curry"),
		        1 => array(
	        			"id" => 2,
	        			"item" => "Green Curry"),
	    	    2 => array(
	        			"id" => 3,
	        			"item" => "Pananag Curry"),
	    	),
	    ),

	);

	echo json_encode($arr);

?>
