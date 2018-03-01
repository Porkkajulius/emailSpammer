<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Create project</title>
</head>
<body>
 <form name="LopullinenHetu" action="laske" method="POST">
  <br><br>
  <table>
   <tr>
    <td>Syntymäpäivä DD: <input type="text" name="paiva"/></td>
    <td>Syntymäkuukausi MM: <input type="text" name="kuukausi"/></td>
    <td>Syntymävuosi kaksi viimeistä numeroa YY: <input type="text" name="vuosi"/></td>
   </tr>

  <#if LopullinenHetu??>
   <tr>
    <td>Laskettu hetu: ${LopullinenHetu}</td>
   </tr>
  </#if>
  
   <tr>   	
    <td><input type="submit"/></td>
   </tr>
  </table>
 </form>
</body>
</html>