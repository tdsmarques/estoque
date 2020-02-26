(function(){
    getProdutos();
  })();
var selectedRow = null
var idTemp = null   



function getProdutos(){
    var url = "http://localhost:3030/produto"; 
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, false);
    xhttp.send();
    var myArr = JSON.parse(xhttp.responseText);
    
    myArr.forEach(function(produto){
            inserirNovaLinha(produto)
      });
}

function enviarForm() {
    if (validate()) {
        var formData = lerInfoForm();
        if (selectedRow == null){
            inserirNovaLinha(formData);
            salvarProduto(formData);
            limpaForm();
            idTemp = null
        }
        else {
            atualizarProduto(formData);            
        }
        limpaForm()            
    }
}

function salvarProduto(data){

    var json = JSON.stringify(data);
    var url = "http://localhost:3030/produto";
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", url, false);
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhttp.send(json);
}

function lerInfoForm() {
    var formData = {};
    formData["nome"] = document.getElementById("form_nome").value;
    formData["unidade"] = document.getElementById("form_unidade").value;
    formData["quantidade"] = document.getElementById("form_quantidade").value;
    let valPerecivel = document.getElementById("form_perecivel").value;
    let perecivel = null
    if(valPerecivel == 0){
        perecivel = false
    }else {
        perecivel = true
    }

    formData["perecivel"] = perecivel
    return formData;
}

function inserirNovaLinha(data) {
    var table = document.getElementById("produtoList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell0 = newRow.insertCell(0);
    cell0.innerHTML = data.nome;
    cell1 = newRow.insertCell(1);
    cell1.innerHTML = data.unidade;
    cell2 = newRow.insertCell(2);
    cell2.innerHTML = data.quantidade;
    cell3 = newRow.insertCell(3);

    if(data.perecivel == false){
        cell3.innerHTML = "NÃO";
    }else {
        cell3.innerHTML = "SIM";
    }
    
    cell4 = newRow.insertCell(4);
    cell4.innerHTML = `<button type="button" onClick="editarProduto(this)" data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-warning">Editar</button>
                       <button type="button" onClick="excluirProduto(this)" class="btn btn-danger">Excluir</button>`;
    cell5 = newRow.insertCell(5);
    cell5.innerHTML = data.id
    cell5.setAttribute("style", "display:none;");
    cell5.setAttribute("id", "indentificador" + newRow.rowIndex)
}

function limpaForm() {
    document.getElementById("form_nome").value = "";
    document.getElementById("form_unidade").value = "";
    document.getElementById("form_quantidade").value = "";
    document.getElementById("form_perecivel").value = 1;
    selectedRow = null;
}

function editarProduto(td) {
    selectedRow = td.parentElement.parentElement;

    document.getElementById("form_nome").value = selectedRow.cells[0].innerHTML;
    document.getElementById("form_unidade").value = selectedRow.cells[1].innerHTML;
    document.getElementById("form_quantidade").value = selectedRow.cells[2].innerHTML;
    console.log(selectedRow.cells[3].innerHTML)
    if(selectedRow.cells[3].innerHTML == "SIM"){
        document.getElementById("form_perecivel").value = 1;
    } else {
        document.getElementById("form_perecivel").value = 0;
    }
    idTemp = selectedRow.cells[5].innerHTML;
}

function atualizarProduto(formData) {

    var json = JSON.stringify(formData);
    var url = "http://localhost:3030/produto/" + idTemp;
    var xhttp = new XMLHttpRequest();
    xhttp.open("PUT", url, false);
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhttp.send(json);

    selectedRow.cells[0].innerHTML = formData.nome;
    selectedRow.cells[1].innerHTML = formData.unidade;
    selectedRow.cells[2].innerHTML = formData.quantidade;
    if(formData.perecivel == true){
        selectedRow.cells[3].innerHTML = "SIM"
    }else {
        selectedRow.cells[3].innerHTML = "NÃO"
    }    
    
}

function excluirProduto(td) {
    if (confirm('Tem certeza que deseja deletar?')) {
        linha = td.parentElement.parentElement;
        id = linha.cells[5].innerHTML;
        var url = "http://localhost:3030/produto/" + id; 
        var xhttp = new XMLHttpRequest();
        xhttp.open("DELETE", url, false);
        xhttp.send();
        document.getElementById("produtoList").deleteRow(linha.rowIndex);
    }
}

function validate() {    
    isValid = true;
    if (document.getElementById("form_nome").value == "" || 
        document.getElementById("form_unidade").value == "" ||
        document.getElementById("form_quantidade").value == "") {
        alert("Existem Campos em Branco")
        return isValid = false;
    }
    return isValid;
}