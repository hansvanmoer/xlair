<!DOCTYPE html> 
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html data-ng-app="xlair">
    <head>

        <title>XLAir</title>

        <jsp:include page="head-include.jsp"/>

    </head>
    <body>
        <h1>It Works !!!</h1>
        <div class="row">
            <div class="col-md-6" data-ng-controller="searchTrackController">
                <h2>Top 100 nummers</h2>
                <form>
                    <label>Zoeken</label>
                    <input type="text" data-ng-model="filter" data-ng-change="updateTracks()"/>
                </form>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Titel</th>
                            <th>Uitvoerder</th>
                            <th>
                                <label ng-show="data.results.length !== 0">({{firstIndex+1}} - {{firstIndex+data.length}}) van {{data.totalResultCount}}</label>
                            </th>
                        </tr>
                    </thead>
                    <tbody data-ng-show="data !== null">
                        <tr data-ng-repeat="track in data.results">
                            <td>{{track.title}}</td>
                            <td>{{track.artist.name}}</td>
                            <td>
                                <button type="button" class="btn btn-default btn-lg">
                                    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                                </button>                                
                            </td>
                        </tr>
                        <tr data-ng-repeat="i in paddingRows track by $index">
                            <td colspan="3"></td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="3" class="row">
                                <div class="col-md-3">
                                    <button type="button" class="btn btn-default btn-lg" data-ng-click="first()" data-ng-show="firstIndex !== 0">
                                        <span class="glyphicon glyphicon-fast-backward" aria-hidden="true"></span>
                                    </button>
                                </div>
                                <div class="col-md-3">
                                    <button type="button" class="btn btn-default btn-lg" data-ng-click="previous()" data-ng-show="firstIndex !== 0">
                                        <span class="glyphicon glyphicon-backward" aria-hidden="true"></span>
                                    </button>         
                                </div>
                                <div class="col-md-3">
                                    <button type="button" class="btn btn-default btn-lg" data-ng-click="next()" data-ng-show="(firstIndex + fetchSize) < data.totalResultCount">
                                        <span class="glyphicon glyphicon-forward" aria-hidden="true"></span>
                                    </button>
                                </div>
                                <div class="col-md-3">
                                    <button type="button" class="btn btn-default btn-lg" data-ng-click="last()" data-ng-show="(firstIndex + fetchSize) < data.totalResultCount">
                                        <span class="glyphicon glyphicon-fast-forward" aria-hidden="true"></span>
                                    </button>   
                                </div>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <div class="col-md-6">
                <h2>Mijn top 5</h2>
                <table class="table table-striped">
                </table>
            </div>
        </div>



    </body>
</html>