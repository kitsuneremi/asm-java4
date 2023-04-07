<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"
	integrity="sha512-2rNj2KJ+D8s1ceNasTIex6z4HWyOnEYLVC3FigGOmyQCZc2eBXKgOxQmo3oKLHyfcj53uz4QMsRCWNbLd32Q1g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>

<body>
	<c:import url="nav.jsp" />
	<div style="display: flex">
		<div class="col-9" style="padding: 2% 8%">
			<div style="padding: 5%">
				<video src="a"></video>
			</div>
			<div>
				<h2>${video.title}</h2>
			</div>
			<div>
				<p>${video.description}</p>
			</div>
			<div class="row">
				<div class="col-3 offset-6">
					<button>like</button>
					<button>dislike</button>
				</div>
			</div>
		</div>
		<div class="col-3">
			<c:forEach var="i" begin="1" end="3" step="1">
				<div>
					<div style="padding: 5%; border: 1px solid black">
						<form action="">
							<div style="border: 1px solid black">
								<img
									src="https://static.wikia.nocookie.net/honkaiimpact3_gamepedia_en/images/d/de/Herrscher_of_Human_-_Ego.png/revision/latest?cb=20220910103158" />
							</div>
						</form>
					</div>
					<div>
						<h3>video title</h3>
					</div>
					<div>
						<button>like</button>
						<button>share</button>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>