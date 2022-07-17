<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Изделие</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Изделие</th>
                    <th scope="col">Серийный номер</th>
                    <th scope="col">Дата выпуска</th>
                    <th scope="col">Войсковая часть</th>
                </tr>
                <#list products as product>
                <tr>
                    <th>${product.id}</th>
                    <th>${product.modelOfTechnical.title}</th>
                    <th>${product.serialNumber}</th>
                    <th>${product.dateOfProduction}</th>
                    <th>${product.regiment.title}</th>
                    <th><a href="/products/edit/${product.id}">Редактировние</a></th>
                    <th><a href="/products/delete/${product.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Изделий нет</h3>
            </#list>
            </table>
    <form method="get" action="/products">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по изделиям</label>
                <input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
    </form>
    <hr>
 <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить новое изделие
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/products/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="modelOfTechnical">Изделие</label>
                <input type="text" required class="form-control"
                       id="modelOfTechnical" name="modelOfTechnical">
            </div>
             <div class="form-group">
                <label for="serialNumber">Серийный номер</label>
                <input type="text" required class="form-control"
                id="serialNumber" name="serialNumber">
                </div>
            <div class="form-group">
              <label for="dateOfProduction">Дата изготовления</label>
              <input type="date" required class="form-control"
              id="dateOfProduction" name="dateOfProduction">
                            </div>
              <div class="form-group">
               <label for="regiment">Войсковая часть</label>
               <input type="text" required class="form-control"
               id="regiment" name="regiment">
               </div>
                        </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
 </div>
   </@t.template>