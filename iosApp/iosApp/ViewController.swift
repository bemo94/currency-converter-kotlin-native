//
//  ViewController.swift
//  iosApp
//
//  Created by BENNIS MOHAMED on 09/05/2019.
//  Copyright © 2019 Octo. All rights reserved.
//

import UIKit
import SharedCode

class ViewController: UIViewController, ConverterDisplay, UIPickerViewDataSource, UIPickerViewDelegate, UITextViewDelegate {
    
    @IBOutlet weak var result: UIButton!
    @IBOutlet weak var origin: UITextView!
    @IBOutlet weak var destination: UITextView!
    @IBOutlet weak var sevenButton: UIButton!
    @IBOutlet weak var heighButton: UIButton!
    @IBOutlet weak var nineButton: UIButton!
    @IBOutlet weak var fourButton: UIButton!
    @IBOutlet weak var fiveButton: UIButton!
    @IBOutlet weak var sixButton: UIButton!
    @IBOutlet weak var oneButton: UIButton!
    @IBOutlet weak var twoButton: UIButton!
    @IBOutlet weak var threeButtoon: UIButton!
    @IBOutlet weak var zeroButton: UIButton!
    @IBOutlet weak var commaButton: UIButton!
    @IBOutlet weak var resetButton: UIButton!
    @IBOutlet weak var historyButton: UIButton!
    @IBOutlet weak var convertButton: UIButton!
    
    
    var pickOption = ["USD", "EUR", "CHF"]
    var isSelected = 0
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return pickOption.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return pickOption[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if (isSelected == 1) {
            self.origin.text = pickOption[row]
        }
        if (isSelected == 2) {
            self.destination.text = pickOption[row]
        }
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
        isSelected = 0
    }
    
    func displayResult(base: String, to: String, value: String) {
        let alert = UIAlertController(title: "Result", message:  "Result from " + base + " = " + value + " " + to, preferredStyle: .alert)
        let actionOk = UIAlertAction(title: "Ok", style: .default, handler: nil)
        alert.addAction(actionOk)
        self.present(alert, animated: true, completion: nil)
    }
    
    func displayError() {
        let alert = UIAlertController(title: "Error", message:  "Oups, an error happened", preferredStyle: .alert)
        let actionOk = UIAlertAction(title: "Ok", style: .default, handler: nil)
        alert.addAction(actionOk)
        self.present(alert, animated: true, completion: nil)
    }
    
    func displayAppend(value: String) {
        result.setTitle(value, for: .normal)
    }
    
    func displayReset(value: String) {
        result.setTitle(value, for: .normal)
    }
    
    var mainDi: MainDi?
    var controller: ConverterController?
    let pickerView = UIPickerView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.mainDi = MainDi.init(displayer: self)
        controller = mainDi?.getController()
        
        pickerView.delegate = self
        origin.delegate = self
        destination.delegate = self
        
        origin.inputView = pickerView
        destination.inputView = pickerView
        
        result.layer.cornerRadius = 18
        oneButton.layer.cornerRadius = 18
        twoButton.layer.cornerRadius = 18
        threeButtoon.layer.cornerRadius = 18
        fourButton.layer.cornerRadius = 18
        fiveButton.layer.cornerRadius = 18
        sixButton.layer.cornerRadius = 18
        sevenButton.layer.cornerRadius = 18
        heighButton.layer.cornerRadius = 18
        nineButton.layer.cornerRadius = 18
        zeroButton.layer.cornerRadius = 18
        commaButton.layer.cornerRadius = 18
        resetButton.layer.cornerRadius = 18
        historyButton.layer.cornerRadius = 18
        convertButton.layer.cornerRadius = 18
        
    }
    
    func textViewShouldBeginEditing(_ textView: UITextView) -> Bool {
        if textView == origin  {
            origin.isEditable = true
            isSelected = 1
            print("1")
            return true
        }
        
        if textView == destination {
            destination.isEditable = true
            isSelected = 2
            print("2")
            return true
        }
        
        print(0)
        
        return false
    }
    
    @IBAction func append(_ sender: UIButton) {
        let button = sender as UIButton
        controller?.append(initial: (result.titleLabel?.text)!, value: (button.titleLabel?.text)!)
    }
    
     func textField(textField: UITextField, shouldChangeCharactersInRange range: NSRange, replacementString string: String) -> Bool {
        return false
    }
    
    @IBAction func convert(_ sender: UIButton) {
        controller?.convert(base: origin.text!, to: destination.text!, value: (result.titleLabel?.text)!)
    }
    
    @IBAction func history(_ sender: UIButton) {}
    
    @IBAction func revert(_ sender: UIButton) {
        let tmp = origin.text
        origin.text = destination.text
        destination.text = tmp
    }
    
    @IBAction func reset(_ sender: UIButton) {
        controller?.reset()
    }
}
