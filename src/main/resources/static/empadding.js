function postemp(){
	const   id=document.getElementById('id').value;
	const    name=document.getElementById('name').value;
	const    sal=document.getElementById('sal').value;
	const    exp=document.getElementById('exp').value;
	const    loc=document.getElementById('loc').value;
	const abc={
		"empid": id,
		"empname": name,
		"salary": sal,
		"experience": exp,
		"location": loc	
	};
	fetch('http://localhost:8080/employee/'+id,{
		method: 'POST',
			headers: {
				'Content-Type': 'application/json'  // Indicating that we are sending JSON
			},
			body: JSON.stringify(abc)  // Convert the object to a JSON string
		})
		.then(response => response.json())  // Parse the JSON response
			.then(data => {
				console.log('Success:', data);
			})
		.catch(error => {
				console.error('Error:', error);
			});
	}
	
