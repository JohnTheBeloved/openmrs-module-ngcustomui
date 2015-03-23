${ ui.includeFragment("uiframework", "helloUser") }

${ ui.includeFragement("ngcustomui", 
						"encountersToday", 
						[start: "2011-02-16", 
						 	end: "2011-02-16 23:59:59.999",
						 	properties: ["location", "datetime"]
						]
				    ) 
}
