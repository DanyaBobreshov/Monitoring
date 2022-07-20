<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Статистика по ОВУ</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">ОВУ</th>
                    <th scope="col">Всего</th>
                    <th scope="col">Гарантийные всего</th>
                    <th scope="col">Гарантийные с задержкой</th>
                    <th scope="col">Негарантийные всего</th>
                    <th scope="col">Негарантийные с задержкой</th>
                </tr>
                <#list fourTables as fourTable>
                <tr>
                    <th>${fourTable.division}</th>
                    <th>${fourTable.all}</th>
                    <th>${fourTable.garantAll}</th>
                    <th>${fourTable.garantDate}</th>
                    <th>${fourTable.nonGarantAll}</th>
                    <th>${fourTable.nonGarantDate}</th>
                </tr>
                <#else>
                <h3>Задержек нет</h3>
                            </#list>
            </table>
    <form method="get" action="/appFourTable">
    </form>
    <hr>
    <form action="/appFourTable/print" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input type="submit" class="btn btn-light" value="ПЕЧАТЬ">
                        </form>
       </@t.template>