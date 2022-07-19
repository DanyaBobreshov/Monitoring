<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Мониторинг технического состояния</h1><hr>
    <a href="/appFourTable">Статистика по ОВУ</a></h2><hr>
    <a href="/appFour-divisions">Поиск по ОВУ</a></h2><hr>
    <a href="/appFour-products">Поиск по Изделиям</a></h2><hr>
    <a href="/appFour-industrials">Поиск по Предприятиям</a></h2><hr>
    <a href="/appFour-garant">Только гарантийные</a>     <a href="/appFour-nonGarant">Только не гарантийные</a> </h2><hr>
    <h2 style="text-align: center">Изделия находящиеся в ремонте более 60 суток</h1><hr>
     <a href="/appFour60-divisions">Поиск по ОВУ</a></h2><hr>
        <a href="/appFour60-products">Поиск по Изделиям</a></h2><hr>
        <a href="/appFour60-industrials">Поиск по Предприятиям</a></h2><hr>
        <a href="/appFour60-garant">Только гарантийные</a>     <a href="/appFour60-nonGarant">Только не гарантийные</a> </h2><hr>

    </@t.template>