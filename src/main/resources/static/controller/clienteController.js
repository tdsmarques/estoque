(function(){
    getClientes();
  })();
var selectedRow = null
var idTemp = null   



function getClientes(){
    var url = "http://localhost:3030/cliente"; 
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, false);
    xhttp.send();
    var myArr = JSON.parse(xhttp.responseText);
    
    myArr.forEach(function(cliente){
            inserirNovaLinha(cliente)
      });
}

function enviarForm() {
    if (validate()) {
        var formData = lerInfoForm();
        if (selectedRow == null){
            inserirNovaLinha(formData);
            salvarCliente(formData);
            limpaForm();
            idTemp = null
        }
        else {
            atualizarCliente(formData);            
        }
        limpaForm()            
    }
}

function salvarCliente(data){

    var json = JSON.stringify(data);
    var url = "http://localhost:3030/cliente";
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", url, false);
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhttp.send(json);
}

function lerInfoForm() {
    var formData = {};
    formData["nome"] = document.getElementById("form_nome").value;
    var tipo_pessoa
    if(document.getElementById("form_tipo_pessoa_fisica").checked == true){
        tipo_pessoa = "PESSOA_FISICA"
    }else {
        tipo_pessoa = "PESSOA_JURIDICA"
    }
    formData["tipoPessoa"] = tipo_pessoa;

    formData["nrDocumento"] = document.getElementById("form_nr_documento").value;
    return formData;
}

function inserirNovaLinha(data) {
    var table = document.getElementById("clienteList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.nome;
    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.tipoPessoa;
    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.nrDocumento;
    cell3 = newRow.insertCell(3);
    cell3.innerHTML = `<button type="button" onClick="editarCliente(this)" data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-warning">Editar</button>
                       <button type="button" onClick="excluirCliente(this)" class="btn btn-danger">Excluir</button>`;
    cell5 = newRow.insertCell(4);
    cell5.innerHTML = data.id
    cell5.setAttribute("style", "display:none;");
    cell5.setAttribute("id", "indentificador" + newRow.rowIndex)
}

function limpaForm() {
    document.getElementById("form_nome").value = "";
    document.getElementById("form_tipo_pessoa_fisica").checked = true;
    document.getElementById("form_nr_documento").value = "";
    selectedRow = null;
}

function editarCliente(td) {
    selectedRow = td.parentElement.parentElement;

    document.getElementById("form_nome").value = selectedRow.cells[0].innerHTML;
    if(selectedRow.cells[1].innerHTML == "PESSOA_FISICA"){
        document.getElementById("form_tipo_pessoa_fisica").checked = true;
    } else {
        document.getElementById("form_tipo_pessoa_juridica").checked = true;
    }
    document.getElementById("form_nr_documento").value = selectedRow.cells[2].innerHTML;
    idTemp = selectedRow.cells[4].innerHTML;
}

function atualizarCliente(formData) {

    var json = JSON.stringify(formData);
    var url = "http://localhost:3030/cliente/" + idTemp;
    var xhttp = new XMLHttpRequest();
    xhttp.open("PUT", url, false);
    xhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhttp.send(json);

    selectedRow.cells[0].innerHTML = formData.nome;
    selectedRow.cells[1].innerHTML = formData.tipoPessoa;
    selectedRow.cells[2].innerHTML = formData.nrDocumento;
}

function excluirCliente(td) {
    if (confirm('Tem certeza que deseja deletar?')) {
        linha = td.parentElement.parentElement;
        id = linha.cells[4].innerHTML;
        var url = "http://localhost:3030/cliente/" + id; 
        var xhttp = new XMLHttpRequest();
        xhttp.open("DELETE", url, false);
        xhttp.send();
        document.getElementById("clienteList").deleteRow(linha.rowIndex);
    }
}

function validate() {    
    isValid = true;
    if (document.getElementById("form_nome").value == "" || document.getElementById("form_nr_documento").value == "") {
        alert("Existem Campos em Branco")
        return isValid = false;
    }
    console.log("VALIDOU O FORM") 
    return isValid;
}