//
//  ViewController.swift
//  iosApp
//
//  Created by mohamed bennis on 17/10/2019.
//  Copyright © 2019 mohamed bennis. All rights reserved.
//

import UIKit
import SharedCode
    
class ViewController: UIViewController, Displayer {

    @IBOutlet weak var label: UILabel!
    
    func display(string: String) {
        label.text = string
    }
    
    var kotlinDi: KotlinDi?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        kotlinDi = KotlinDi(displayer: self)
        kotlinDi?.getPresenter().presentConcat()
        
    }


}

