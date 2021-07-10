var check=null;
var chkarr=new Array();
var page=0;
const getData = ()=>{
  
 
    fetch("http://localhost:8085/H2HBABBA1678/Fetch")
    .then((res)=>{
      return res.json();
    })
    .then((data)=>{
      populategrid(data)
    })
    .catch((e)=>{
      
    })
    enable();
  }


const populategrid=(data)=>
{

    const  tableb = document.getElementById("customers");
  let content="";
  for(row of data)
  {
      
      content +=`<tr>
       <td><input type="checkbox"  id="chk" class="chk" onclick="checkedbox('${row.invoiceID}')"</td>
       <td>${row.customerName}</td>
       <td>${row.cutomerNumber}</td>
       <td>${row.invoiceID}</td>
       <td>${row.openAmount}</td>
       <td>${row.dueDate}</td>
       <td>${row.clearDate || "--"}</td>
       <td>${row.note || "--"}</td>
       </tr>`
       tableb.innerHTML=content;
  }
}
function checkedbox(invcId)
{
  check=invcId;
  chkarr.push(check);
  enable();
}
function enable()
{
  let delbtn=document.getElementById('del-Btn');
  let editbtn=document.getElementById('editBtn');
  if(check==null)
  {
    delbtn.disabled=true;
    editbtn.disabled=true;
  }
  else
  {
    delbtn.disabled=false;
    editbtn.disabled=false;
  }
  if(chkarr.length>1)
    editbtn.disabled=true;

}
function del(){
	var box="";
        for(var i=0;i<chkarr.length;i++)
        {
          box+=chkarr[i]+",";
        }
       fetch("http://localhost:8085/H2HBABBA1678/Delete?checked="+box)
  .then((res)=>{
    
  })
  .then((data)=>{
    
  })
  .catch((e)=>{
    
  })
  chkarr=[];
}