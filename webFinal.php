<?php

// $pdo = new PDO('mysql:host=localhost;port=3306;dbname=courseassigner', 'root', '');
// $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
// $sql = "SELECT Name, serial, TeacherCode FROM employee;" ;
// $statement = $pdo->prepare($sql);
// $statement->execute();
// $facultys = $statement->fetchAll(PDO::FETCH_ASSOC);


$pdo =  new PDO('mysql:host=localhost;port=3306;dbname=test', 'root', '');
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

if($_SERVER['REQUEST_METHOD'] == "POST"){
    echo "POSTED";

    if(isset($_POST['inp1']) && isset($_POST['inp2'])){
        $inp1 = $_POST['inp1'];
        $inp2 = $_POST['inp2'];

        $sql = "INSERT INTO `courses`(`code`, `section`, `day`, `new`) VALUES ('CSE1234','Section X','$inp1','$inp2')";
        // $sql = "Select * from courses";
        $statement = $pdo->prepare($sql);
        $statement->execute();
        // $results = $statement->fetchAll(PDO::FETCH_ASSOC);

        echo "<pre>";
        // var_dump($results);
        echo "</pre>";
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="#" method="POST">
        <input type="text" name="inp1">
        <input type="text" name="inp2">
        <button type="submit">Submit</button>
    </form>
</body>
</html>