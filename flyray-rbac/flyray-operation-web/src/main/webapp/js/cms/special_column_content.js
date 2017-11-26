$(document).ready(function(){
	var self = this;
	$.ajax({
		type: "POST",
	    url: "../cms/specialColumnContent/list",
        contentType: "application/json",
	    success: function(r){
			if(r.code == 0){
				vm.itemList = r.page.list;
				console.log(vm.itemList)
			}else{
				
			}
		}
	});
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			columnName: null
		},
		showList: true,
		title:null,
		specialColumn:{
			columnName:null,
			columnDesc:null,
			columnLogo:null,
            columnStatus:null,
			createBy:null
		},
		itemList:[]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.specialColumn = {
                columnName:null,
                columnDesc:null,
                columnLogo:null,
                columnStatus:null,
                createBy:null
            }
		},
		update: function (id) {
			if(id == null){
				return ;
			}
            vm.title = "修改";
			
			vm.getSpecialColumn(id);
            vm.showList = false;
		},
		del: function (id,index) {
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../cms/specialColumnContent/delete",
                    contentType: "application/json",
				    data: JSON.stringify(id),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.itemList.splice(index,1);
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		saveOrUpdate: function (event) {
			var url = vm.specialColumn.id == null ? "../cms/specialColumnContent/save" : "../cms/specialColumnContent/update";
			$.ajax({
				type: "POST",
			    url: url,
                contentType: "application/json",
			    data: JSON.stringify(vm.specialColumn),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		getSpecialColumn: function(id){
			alert(id)
			$.get("../cms/specialColumnContent/info/"+id, function(r){
				vm.specialColumn = r.specialColumn;
			});
		},
		reload: function (event) {
			vm.showList = true;
		}
	}
});