<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin-top:70px;"></div> 

<form name="f" action="Memowrite.do" method="get"> <!-- html에서는 / 뺴야함  -->
 <div align="center"> 
    <table width="600" border="0" cellpadding="7" > 
        <tr align="center" bgcolor="gold" height="50"> 
            <td colspan="2"> 
                <font size="4" color="#0033CC" face="굴림체"> 
                <b> 
                   Servlet Memo
                </b> 
                </font> 
            </td> 
        </tr> 
        <tr> 
            <td width="25%" align="center" > 
                <b>ID</b> 
            </td> 
            <td> 
                <input type="text" size="40" name="id" maxlength="10" > 
            </td> 
        </tr>     
        <tr> 
            <td width="25%" align="center"> 
                <b>EMAIL</b> 
            </td> 
            <td> 
                <input type="text" size="40" name="email" maxlength="60" > 
            </td> 
        </tr> 
        <tr> 
            <td width="25%" align="center"> 
                <b>MEMO</b> 
            </td> 
            <td> 
                <textarea name="content" cols="50" class="box2"></textarea> 
            </td> 
        </tr> 
        <tr bgcolor="gold"> 
            <td colspan="2" align="center" class="c2"> 
                <input type="submit" value="전송" >
                <input type="reset" value="취소"> 
            </td> 
        </tr> 
     
    </table> 
 </div>
</form>
</body>
</html>