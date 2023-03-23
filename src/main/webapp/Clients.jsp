<%@page import="dao.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>Users List</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css">
</head>
<body class = "bg-dark">

<%@include file="header.jsp" %>
  <h1 class = "text-white">Users List</h1>
  <table id="client-table" class="table table-striped table-bordered table-hover table-dark">
    <thead>
      <tr>
        <th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Adress</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
      <%
        ClientDao clientDao = new ClientDao();
      InformationDao informationDao = new InformationDao();
        for (Client client : clientDao.AfficherTout()) {
          //	Categorie categorie = categorieDao.rechercherById(product.getCategorieId());
          Information info = client.getInformation();
      %>
        <tr>
          <td><%= client.getId_client() %></td>
          <td><%= client.getPrenom() %></td>
          <td><%= client.getNom()  %></td>
          <td><%= info.getEmail() %></td>
          <td><%= info.getAdress() %></td>
          <td ><button class="btn btn-success edit-product" onclick="editClient(<%= client.getId_client() %>)" data-product-id="<%= client.getId_client() %>">Edit</button></td>
          <td ><button class="btn btn-danger delete-product" onclick="deleteClient(<%= client.getId_client() %>)"  data-product-id="<%= client.getId_client() %>">Delete</button> </td>
        </tr>
      <% } %>
    </tbody>
  </table>
  
  <button class="btn btn-primary" onclick="createClient()">Add Client</button>
  
  <script type="text/javascript">
  function createClient() {
	  window.location.href = "create-client.jsp";
	}
  </script>
  
  
  <script>
  $(document).ready(function() {
    $('#product-table').DataTable({
      "language": {
        "url": "https://cdn.datatables.net/plug-ins/1.11.3/i18n/en.json"
      },
    });
  });
</script>

<script>
function deleteClient(id) {
  if (confirm("Are you sure you want to delete this Client?")) {
    $.ajax({
      url: "deleteClient.jsp?id=" + id,
      method: "POST",
      success: function(response) {
        alert("Client deleted successfully");
        window.location.reload();
      },
      error: function(xhr, status, error) {
        alert("An error occurred while deleting the Client");
      }
    });
  }
}
</script>


<script>
function editClient(id) {
	  window.location.href = "edit-client.jsp?id=" + id;
	}
</script>
</body>
</html>


