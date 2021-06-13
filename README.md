# TestChangeTableColor

這個簡單小專案主要是練習把 網頁上 &lt;table&gt; 每一列上不同顏色，  
我用 CustomerBean JavaBean 來代表每一列的資料，  
專案結構簡單沒有連線資料庫，  
而是以 static ArrayList 來模擬後端程式取到資料庫的值，  
當使用者透過下拉式選單更改顏色，  
勾選要改的指定列，接著按下按鈕。  
JavaScript程式會透過AJAX技術把要修改的顏色與列數用JSON格式資料打到後端程式，  
並由後端程式接收JSON資料解析後，  
重新修改 static ArrayList 的值。  
再次刷新頁面顯示修改好的畫面。  