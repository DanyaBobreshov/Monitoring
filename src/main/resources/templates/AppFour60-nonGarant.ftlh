<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Неисправности</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Изделие наименование</th>
                    <th scope="col">Изделие серийный номер</th>
                    <th scope="col">Гарантийное</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Дата</th>
                    <th scope="col">Предприятие</th>
                    <th scope="col">Документ</th>
                </tr>
                <#list incidents as incident>
                <tr>
                    <th>${incident.id}</th>
                    <th>${incident.product.modelOfTechnical.title}</th>
                    <th>${incident.product.serialNumber}</th>
                    <th>${incident.isGarant?c}</th>
                    <th>${incident.description}</th>
                    <th>${incident.dateOfIncident}</th>
                    <th>${incident.industrial.title}</th>
                    <th>${incident.document}</th>
                    <th><a href="/incident/edit/${incident.id}">Редактировние</a></th>
                    <th><a href="/incident/delete/${incident.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Неисправностей нет</h3>
            </#list>
            </table>
    <form method="get" action="/appFour60-Nongarant">
    </form>
    <hr>
       </@t.template>