<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <jsp:include page="template/header.jsp"/>
  <script type="text/javascript">
		$(function(){
			$("#tabla").DataTable({
	            responsive: true
	        });
			$( "form" ).validate( {
				rules: {
					tipoDocumento:{notEqual : "-1"},
					name: "required",
				},
				messages: {
					tipoDocumento: "Select a Company Type",
					nroDocumento: "Please insert a Name"
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parent().addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parent().addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
		});
  	
  </script>
  
  <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                       
                       
                        <div class="panel panel-default">
                        <div class="panel-heading">
                           Company List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="tabla">
                                <thead>
                                    <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Gender</th>
                                        <th>Phone</th>
                                        <th>E-mail</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                   <c:forEach items="${customerList}" var="customer">
                                    <tr>
                                        <td>${customer.firstName}</td>
                                        <td>${customer.lastName}</td>
                                        <td class="center">${customer.gender}</td> 
                                        <td class="center">${customer.phone}</td> 
                                        <td class="center">${customer.email}</td> 
                                        <td><a href="${pageContext.request.contextPath}/customer/${customer.id}"><span class="glyphicon glyphicon-edit" title="edit"></span></a></td>
                                        <td><a href="${pageContext.request.contextPath}/deleteCustomer/${customer.id}" ><span class="glyphicon glyphicon-trash" title="remove"></span></a></td>
                                    </tr>
                                  </c:forEach>
                       
                                </tbody>
                            </table>
                          
                        </div>
                        <!-- /.panel-body -->
                    </div>
                       
                  </div>
                    <!-- /.col-lg-12 -->
               </div>
                <!-- /.row -->
               <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">       
                       
                       
                        <div class="panel panel-default">
                        <div class="panel-heading">
                         <h4> Customer : <c:out value="${customer.firstName}"></c:out></h4>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                       
                        <form:form method="POST" modelAttribute="customer" action="${pageContext.request.contextPath}/customer"  >
                                        
                                       
                                       
                                       
                                        <div class="form-group">
                                        	<form:hidden path="id"/>
                                        	
                                            <label>First Name </label>
                                             <form:input cssClass="form-control" path="firstName" />
                                        </div>
                                        <div class="form-group">
                                            <label>Last Name </label>
                                            <form:input cssClass="form-control" path="lastName" />
                                        </div>
                                         <div class="gender">
                                            <label>Gender </label>
                                            <form:radiobutton cssClass="form-control" path="gender" />
                                            <form:radiobutton cssClass="form-control" path="gender" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Phone </label>
                                            <form:input cssClass="form-control" path="phone" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Email </label>
                                            <form:input cssClass="form-control" path="email" />
                                        </div>
                                        
                                        <button type="submit" class="btn btn-default">Save</button>
                                        
                           </form:form> 
                      </div>
                    
                 <!-- /.panel-body -->
                    </div>             
                      	
                    </div>
                    <!-- /.col-lg-6 -->
                     <div class="col-lg-6">
                       <!-- /.table-responsive -->
                          
                     </div>
                </div>
                <!-- /.row -->
               </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
   <jsp:include page="template/footer.jsp"/>