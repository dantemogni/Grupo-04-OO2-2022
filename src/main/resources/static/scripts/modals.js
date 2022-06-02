
  $("#deleteModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
  
    var id = button.data("id"); // Extract info from data-* attributes
    var content = button.data("content");
    var modal = $(this);

    var deleteLink = "/delete/"+id
  
    modal.find("#itemIdDelete").attr("action", deleteLink);
    modal.find("#itemContentDelete").text(content);
  
  });