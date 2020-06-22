<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쇼부</title>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body>
    <div class="area"></div>
    <nav class="main-menu">
        <ul>
            <li>
                <a href="http://justinfarrow.com">
                    <i class="fa fa-home fa-2x"></i>
                    <span class="nav-text">
                        Home
                    </span>
                </a>

            </li>
            <li class="has-subnav">
                <a href="#">
                    <i class="fa fa-play fa-2x"></i>
                    <span class="nav-text">
                        Game
                    </span>
                </a>

            </li>
            <li>
                <a href="#">
                    <i class="fa fa-bar-chart-o fa-2x"></i>
                    <span class="nav-text">
                        Statistics
                    </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-map-marker fa-2x"></i>
                    <span class="nav-text">
                        Maps
                    </span>
                </a>
            </li>
        </ul>

        <ul class="logout">
            <li>
                <a href="#">
                    <i class="fa fa-power-off fa-2x"></i>
                    <span class="nav-text">
                        Logout
                    </span>
                </a>
            </li>
        </ul>
    </nav>
    <div class="search-wrapper">
        <div class="input-holder">
            <input type="text" class="search-input" placeholder="Type to search" />
            <button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
        </div>
        <span class="close" onclick="searchToggle(this, event);"></span>
    </div>
    <table>
        <tr>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
            <td>
                <div class="card">
                    <p>Architect & Engineer</p>
                </div>
            </td>
        </tr>
    </table>

    <div id="chat-circle" class="btn btn-raised">
            <div id="chat-overlay"></div>
                <i class="fa fa-comments fa-2x chatIcon"></i>
        </div>
      
      <div class="chat-box">
        <div class="chat-box-header">
          ChatBot
          <span class="chat-box-toggle"><i class="fa fa-times"></i></span>
        </div>
        <div class="chat-box-body">
          <div class="chat-box-overlay">   
          </div>
          <div class="chat-logs">
           
          </div><!--chat-log -->
        </div>
        <div class="chat-input">      
          <form>
            <input type="text" id="chat-input" placeholder="Send a message..."/>
          <button type="submit" class="chat-submit" id="chat-submit"><i class="material-icons">send</i></button>
          </form>      
        </div>
      </div>
    </div>
    
</body>

</html>