<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template product>
    <hr>
        <form action="product-edit/${product.id}" method="post">
             <div class="form-group">
                             <label for="modelOfTechnical">Изделие</label>
                             <input type="text"  value="${product.modelOfTechnical.title}"required class="form-control"
                                    id="modelOfTechnical" name="modelOfTechnical">
                         </div>
                          <div class="form-group">
                             <label for="serialNumber">Серийный номер</label>
                             <input type="text" value="${product.serialNumber}"required class="form-control"
                             id="serialNumber" name="serialNumber">
                             </div>
                         <div class="form-group">
                           <label for="dateOfProduction">Дата изготовления</label>
                           <input type="date" value="${product.dateOfProduction}" required class="form-control"
                           id="dateOfProduction" name="dateOfProduction">
                                         </div>
                           <div class="form-group">
                            <label for="regiment">Войсковая часть</label>
                            <input type="text" value="${product.regiment.title}"required class="form-control"
                            id="regiment" name="regiment">
                            </div>
                                     </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>